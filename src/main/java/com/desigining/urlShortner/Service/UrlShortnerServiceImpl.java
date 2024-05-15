package com.desigining.urlShortner.Service;

import com.desigining.urlShortner.models.UrlShortnerDTO;
import com.desigining.urlShortner.repository.UrlShortnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlShortnerServiceImpl implements UrlShortnerService{

    @Autowired
    private UrlShortnerRepository urlShortnerRepository;
    @Override
    public List<UrlShortnerDTO> getAllUrlShortner() {
        return urlShortnerRepository.findAll();
    }

    @Override
    public String getShortUrl() {
        return null;
    }

    @Override
    public String getOriginalUrl(String tinyUrl) {
        return null;
    }

    @Override
    public String redirectToOriginalUrl(String tinyUrl) {
        return null;
    }
}
