package com.example.graphql.hello.models;

import java.util.List;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Value
@Builder
@ToString
public class Car {

    private final String vin;
    private final String make;
    private final String model;
    private final String year;
    private final String color;
    private final Image image;
    
}
