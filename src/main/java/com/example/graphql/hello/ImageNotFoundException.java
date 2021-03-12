package com.example.graphql.hello;

public class ImageNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ImageNotFoundException(String vin) {
        super(String.format("Could not find image for %s", vin));
    }
    
}
