package io.github.mikeiansky.sample.sb.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        return Mono.delay(Duration.ofSeconds(2)).then(Mono.just("hello : " + msg));
//        return Mono.just("hello : "+msg);
    }

}
