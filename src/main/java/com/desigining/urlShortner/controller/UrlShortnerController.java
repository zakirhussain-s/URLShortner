package com.desigining.urlShortner.controller;

import com.desigining.urlShortner.Service.UrlShortnerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Tag(name = "URL Shortner")
public class UrlShortnerController {

    @Autowired
    private UrlShortnerService urlShortnerService;

    @Operation(summary = "Get all URL shorteners", description = "Retrieves a list of all URL shorteners.")
    @RequestMapping(value = "/allUrls", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUrls(){
        return new ResponseEntity<>(urlShortnerService.getAllUrlShortner(), HttpStatus.OK);
    }

    @Operation(summary = "Create short URL", description = "Creates unique short URL")
    @RequestMapping(value = "/shortUrl", method = RequestMethod.POST)
    public ResponseEntity<?> createdShortUrl(@RequestBody String originalUrl) throws Exception{
        String shortUrl = urlShortnerService.createShortUrl(originalUrl);
        return new ResponseEntity<>(shortUrl, HttpStatus.CREATED);
    }

    @Operation(summary = "Get original URL", description = "Retrieves short URL")
    @RequestMapping(value = "/originalUrl/{shortUrl}",method = RequestMethod.GET)
    public ResponseEntity<?> getOriginalUrl(@PathVariable String shortUrl){
        return new ResponseEntity<>(urlShortnerService.getOriginalUrl(shortUrl),HttpStatus.OK);
    }
}
