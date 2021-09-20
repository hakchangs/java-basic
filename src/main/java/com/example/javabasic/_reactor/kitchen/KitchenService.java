package com.example.javabasic._reactor.kitchen;

import reactor.core.publisher.Flux;

public class KitchenService {

    public Flux<Dish> getDished() {
        //요리 완성!
        return Flux.just(
                new Dish("Sesame chicken"),
                new Dish("Lo mein noodles, plain"),
                new Dish("Sweet & sour beef"));
    }
}
