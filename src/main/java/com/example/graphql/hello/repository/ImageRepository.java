package com.example.graphql.hello.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.graphql.hello.models.Image;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ImageRepository {

    private final List<Image> storage;

    public ImageRepository() {

        Image audiImage = Image.builder()
            .vin("WUARU78E87N903887")
            .url("https://bringatrailer.com/wp-content/uploads/2021/01/2007_audi_rs4_1613587881cc3ab53c202rs4-6-scaled.jpg")
            .build();

        Image mercImage = Image.builder()
            .vin("WDDHH7GB4FB123279")
            .url("https://bringatrailer.com/wp-content/uploads/2019/03/2015_mercedes-benz_e63s_wagon_1553900690611b920a492f3b2251-Mercedes-benz-363s-1-e1554418614293.jpg")
            .build();

        storage = new ArrayList<>(Arrays.asList(audiImage, mercImage));
    }
    
    public Image findByVin(String vin) {
        log.info("Searching in image repository for {}", vin);
        List<Image> images = storage.stream().filter(i -> vin.equals(i.getVin())).collect(Collectors.toList());

        if (images.isEmpty())
            return null;

        return images.get(0);
    }
    
}
