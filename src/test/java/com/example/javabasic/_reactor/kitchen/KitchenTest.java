package com.example.javabasic._reactor.kitchen;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class KitchenTest {

    @Test
    void 서빙() {

        PoliteServer server = new PoliteServer(new KitchenService());

        server.doingMyJob().subscribe(
                dish -> System.out.println("Consuming " + dish),
                throwable -> System.err.println(throwable)
        );
    }

}
