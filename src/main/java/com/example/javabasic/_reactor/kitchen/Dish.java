package com.example.javabasic._reactor.kitchen;

public class Dish {

    private String menu;
    private boolean delivered;

    public Dish(String menu) {
        this.menu = menu;
    }

    public static Dish deliver(Dish dish) {
        dish.delivered = true;
        return dish;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "menu='" + menu + '\'' +
                ", delivered=" + delivered +
                '}';
    }
}
