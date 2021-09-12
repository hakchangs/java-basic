package com.example.javabasic._thread.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadService {

    public void task() {

        log.info(Thread.currentThread().getName());

        //1초 지연작업
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String task(String s) {

        log.info(Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
            return "result: " + s;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
