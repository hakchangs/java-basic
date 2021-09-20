package com.example.javabasic._reactor;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.Fuseable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ReactorTest {

    @Test
    void Flux_기초() {
        List<Integer> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
                .log()
                .subscribe(elements::add);

        //로그 설명
        //1. onSubscribe()     : stream 을 subscribe 하면 발생
        //2. request(unbounded): Subscription 이 만들어지고, stream 에서 요소들을 요청함
        //3. onNext()          : 요소들이 하나씩 넘어옴
        //4. onComplete()      : 모든 요소들이 넘어오고 나면 호출됨
//        21:24:10.660 [main] DEBUG reactor.util.Loggers - Using Slf4j logging framework
//        21:24:10.674 [main] INFO reactor.Flux.Array.1 - | onSubscribe([Synchronous Fuseable] FluxArray.ArraySubscription)
//        21:24:10.676 [main] INFO reactor.Flux.Array.1 - | request(unbounded)
//        21:24:10.676 [main] INFO reactor.Flux.Array.1 - | onNext(1)
//        21:24:10.677 [main] INFO reactor.Flux.Array.1 - | onNext(2)
//        21:24:10.677 [main] INFO reactor.Flux.Array.1 - | onNext(3)
//        21:24:10.677 [main] INFO reactor.Flux.Array.1 - | onNext(4)
//        21:24:10.677 [main] INFO reactor.Flux.Array.1 - | onComplete()

        assertThat(elements).containsExactly(1, 2, 3, 4);
    }

}
