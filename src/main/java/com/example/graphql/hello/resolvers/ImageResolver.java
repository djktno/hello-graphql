package com.example.graphql.hello.resolvers;

import com.example.graphql.hello.models.Car;
import com.example.graphql.hello.models.Image;
import com.example.graphql.hello.services.ImageService;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLResolver;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ImageResolver implements GraphQLResolver<Car> {

    private final ImageService service;

    public Image getImage(Car car) {
        
        return service.getImage(car.getVin());

    }

    
}
