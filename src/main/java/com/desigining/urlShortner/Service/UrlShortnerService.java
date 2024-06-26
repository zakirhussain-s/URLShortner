package com.desigining.urlShortner.Service;

import com.desigining.urlShortner.models.UrlShortnerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UrlShortnerService {

    List<UrlShortnerDTO> getAllUrlShortner();

    String createShortUrl(String originalUrl) throws Exception;

    String getOriginalUrl(String tinyUrl);
    String redirectToOriginalUrl(String tinyUrl);
}
