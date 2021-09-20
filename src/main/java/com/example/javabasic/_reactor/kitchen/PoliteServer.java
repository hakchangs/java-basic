package com.example.javabasic._reactor.kitchen;

import reactor.core.publisher.Flux;

public class PoliteServer {

    private final KitchenService kitchen;

    public PoliteServer(KitchenService kitchen) {
        this.kitchen = kitchen;
    }

    public Flux<Dish> doingMyJob() {
        //서빙시 처리할 역할정의
        return this.kitchen.getDished()
                .log()
                .doOnSubscribe(subscription -> System.out.println("Start serving..."))
                .doOnNext(dish -> System.out.println("Thank you for " + dish + "!"))
                .map(Dish::deliver)
                .doOnError(error -> System.out.println("So sorry about " + error.getMessage()))
                .doOnComplete(() -> System.out.println("Thanks for all your hard work!"))
                ;
    }

}
