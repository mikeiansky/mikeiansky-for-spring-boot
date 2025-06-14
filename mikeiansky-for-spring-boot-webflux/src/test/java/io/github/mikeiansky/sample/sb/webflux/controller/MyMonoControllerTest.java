package io.github.mikeiansky.sample.sb.webflux.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.function.Consumer;

/**
 * @author mike ian
 * @date 2025/6/14
 * @desc
 **/
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyMonoControllerTest {

    @Test
    public void testHello(@Autowired WebTestClient webClient){
        webClient.get().uri("/mono/hello?msg=error")
                .exchange()
                .expectBody(String.class)
                .consumeWith(System.out::println);
    }


}
