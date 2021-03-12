package com.example.graphql.hello.resolvers;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.graphql.hello.models.Car;
import com.example.graphql.hello.models.Tire;

import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;

import static java.util.Arrays.*;

@Component
public class Query implements GraphQLQueryResolver {

    public List<Car> cars() {

        var car1 = Car.builder()
            .year("2007")
            .make("Audi")
            .model("RS4")
            .color("Daytona Grey Pearl Effect")
            .vin("WUARU78E87N903887")
            .build();

        var car2 = Car.builder()
            .year("2015")
            .make("Mercedes-Benz")
            .model("E63 AMG S Wagon")
            .color("Obsidian Black Metallic")
            .vin("WDDHH7GB4FB123279")
            .build();
            

        return asList(car1, car2);
    }

    public List<Car> topCars(int top) {

        var cars = cars();
        if (cars.size() < top) {
            top = cars.size();
        }

        return cars.subList(0, top);
    }

    public Car findByVin(String vin) {
        List<Car> matched = cars().stream().filter(c -> c.getVin().equalsIgnoreCase(vin)).collect(Collectors.toList());

        if (matched.isEmpty())
            return null;

        return matched.get(0);
    }

    
}
