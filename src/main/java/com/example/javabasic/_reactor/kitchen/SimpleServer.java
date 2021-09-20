package com.example.javabasic._reactor.kitchen;

import reactor.core.publisher.Flux;

public class SimpleServer {

    private final KitchenService kitchen;

    public SimpleServer(KitchenService kitchen) {
        this.kitchen = kitchen;
    }

    public Flux<Dish> doingMyJob() {
        return this.kitchen.getDished()
                .map(Dish::deliver);
    }

}
