package io.github.mikeiansky.sample.sb.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author mike ian
 * @date 2024/12/25
 * @desc
 **/
@RequestMapping("mono")
@RestController
public class MyMonoController {

    static {
        System.out.println("MyMonoController static block ... " + MyMonoController.class.getClassLoader());
    }

    @GetMapping("hello")
    public Mono<String> hello(String msg) {
        WebClient.builder().baseUrl("https://www.baidu.com")
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(System.out::println);

        return Mono.delay(Duration.ofSeconds(2)).then(Mono.just("hello : " + msg));
//        return Mono.just("hello : "+msg);
    }

}
