package com.example.javabasic._thread;

import com.example.javabasic._thread.service.ThreadService;
import com.example.javabasic._thread.spring.SpringAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

@Slf4j
@SpringBootTest
class ThreadTest {

    @Disabled
    @Test
    void 단일쓰레드() {

        ThreadService service = new ThreadService();

        //순차적으로 100번의 작업이 수행된다.
        IntStream.range(0, 100).forEach(n -> {

            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ":task start " + n);
            service.task();
            System.out.println(threadName + ":task completed " + n);

        });

    }

    @Disabled
    @Test
    void 다중쓰레드() {

        ThreadService service = new ThreadService();
        Executor executor = Executors.newFixedThreadPool(100);

        //ThreadPoolExecutor 를 이용하여 100번 동시수행한다.
        IntStream.range(0, 100).forEach(n -> executor.execute(() -> {

            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            System.out.println("thread-group=" + threadGroup.getName());

            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + ":task start " + n);
            service.task();
            System.out.println(threadName + ":task completed " + n);

        }));
    }

    @Disabled
    @Test
    void 응답을_포함한_쓰레드() {

        ThreadService service = new ThreadService();
        Executor executor = Executors.newFixedThreadPool(100);

        //1. Future 를 이용하여 미래에 완료될 비동기 작업을 정의한다.
        List<CompletableFuture<String>> futures = new ArrayList<>();
        IntStream.range(0, 100).forEach(n -> futures.add(
                CompletableFuture.supplyAsync(() -> service.task(String.valueOf(n)), executor)
        ));

        //2. 콜백작업을 수행한다. (Future 여러개를 취합후, 콜백수행)
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
                .thenAccept(consumer -> futures.forEach(f -> log.info(f.join())))
                //3. 비동기작업이 완료되길 기다린다. (옵셔널)
                .join();
    }

    @Autowired
    private SpringAsyncService asyncService;

    @Disabled
    @Test
    void 응답을_포함한_쓰레드_inSpring() {

        //1. Future 를 이용하여 미래에 완료될 비동기 작업을 정의한다.
        List<CompletableFuture<String>> futures = new ArrayList<>();
        IntStream.range(0, 100).forEach(n -> {
            futures.add(asyncService.task(String.valueOf(n)));
        });

        //2. 콜백작업을 수행한다. (Future 여러개를 취합후, 콜백수행)
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
                .thenAccept(consumer -> futures.forEach(f -> log.info(f.join())))
                //3. 비동기작업이 완료되길 기다린다. (옵셔널)
                .join();

    }

}