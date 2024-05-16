package com.desigining.urlShortner.Service;

import com.desigining.urlShortner.models.UrlShortnerDTO;
import com.desigining.urlShortner.repository.UrlShortnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class UrlShortnerServiceImpl implements UrlShortnerService{

    @Autowired
    private UrlShortnerRepository urlShortnerRepository;
    @Override
    public List<UrlShortnerDTO> getAllUrlShortner() {
        return urlShortnerRepository.findAll();
    }
    @Override
    public String createShortUrl(String originalUrl) throws Exception{
        long counter = Math.abs((long) (Math.random() * Long.MAX_VALUE));
        String base64Encoded = encodeToBase64(counter);

        String shortUrl = base64Encoded.substring(0,6);
        String baseUrl = "https://example.com/";

        String shortAndBaseUrl = baseUrl + shortUrl;

        UrlShortnerDTO urlShortnerDTO = new UrlShortnerDTO();
        urlShortnerDTO.setOriginalUrl(originalUrl);
        urlShortnerDTO.setTinyUrl(shortUrl);
        urlShortnerDTO.setCreatedDate(new Date().toString());

        UrlShortnerDTO result = urlShortnerRepository.save(urlShortnerDTO);

        if (result == null) {
            throw new Exception("Something went wrong");
        } else {
            return shortAndBaseUrl;
        }
    }

    @Override
    @Cacheable("tinyUrls")
    public String getOriginalUrl(String tinyUrl) {
        Optional<UrlShortnerDTO> result = urlShortnerRepository.findById(tinyUrl);

        final String[] originalUrl = {""};
        result.ifPresent(urlShortnerDTO -> originalUrl[0] = urlShortnerDTO.getOriginalUrl());

        if(result.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Url not found "+tinyUrl);
        }

//      2nd way to get url
//        if(result.isPresent()){
//            UrlShortnerDTO urlShortnerDTO = result.get();
//            String originalUrl = urlShortnerDTO.getOriginalUrl();
//        }
        return Arrays.toString(originalUrl);
    }

    @Override
    public String redirectToOriginalUrl(String tinyUrl) {
        return null;
    }

    private static String encodeToBase64(Long uniqueId){
        return Base64.getEncoder().encodeToString(String.valueOf(uniqueId).getBytes());
    }
}
