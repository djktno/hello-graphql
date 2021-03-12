package com.example.graphql.hello.resolvers;

import java.util.List;
import java.util.UUID;

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
            .tires(asList(
                    Tire.builder()
                    .serial(UUID.randomUUID().toString())
                    .manufacturer("Dunlop")
                    .size("P255/35R19")
                    .build()
                )
            )
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

    public List<Car> cars(int top) {

        var cars = cars();
        if (cars.size() < top) {
            top = cars.size();
        }

        return cars.subList(0, top);
    }

    
}
