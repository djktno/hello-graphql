package com.example.graphql.hello.services;

import com.example.graphql.hello.models.Image;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImageService {

    private final RestTemplate restTemplate;

    public ImageService() {
        restTemplate = new RestTemplate();
    }

    public Image getImage(String vin) {

        String url = String.format("http://localhost:8080/images/%s", vin);
        
        return restTemplate.getForObject(url, Image.class);

    }
    
}
