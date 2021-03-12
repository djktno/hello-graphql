package com.example.graphql.hello.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "ImageBuilder", toBuilder = true)
@JsonDeserialize(builder = Image.ImageBuilder.class)
public class Image {

    @JsonProperty("vin")
    private final String vin;
    @JsonProperty("url")
    private final String url;

    @JsonPOJOBuilder(withPrefix = "")
    public static class ImageBuilder {
    }
    
}
    