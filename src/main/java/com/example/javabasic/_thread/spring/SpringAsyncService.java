package com.example.javabasic._thread.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class SpringAsyncService {

    @Async("taskExecutor")
    public CompletableFuture<String> task(String s) {

        log.info(Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
            s = "result: " + s;
            return new AsyncResult<>(s).completable();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new CompletableFuture<>();

        return new AsyncResult<>(s).completable();
    }

}
