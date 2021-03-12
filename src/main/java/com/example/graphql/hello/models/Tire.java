package com.example.graphql.hello.models;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Value
@Builder
@ToString
public class Tire {
    
    private final String manufacturer;
    private final String serial;
    private final String size;
    
}
