package com.example.graphql.hello.controllers;

import com.example.graphql.hello.models.Image;
import com.example.graphql.hello.repository.ImageRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
public class ImageController {

    private final ImageRepository imageRepository;

    @GetMapping("/images/{vin}")
    public Image one(@PathVariable String vin) {
        log.info("Calling through ReST service for image with vin {}", vin);
        return imageRepository.findByVin(vin);    
    }
    
}
