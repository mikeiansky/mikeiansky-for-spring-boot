package io.github.mikeiansky.sample.sb.webflux.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

/**
 * @author mike ian
 * @date 2025/6/14
 * @desc
 **/
@Component
public class GlobalWebExceptionHandler implements WebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        System.out.println("handler exception : " + ex);
        return Mono.error(ex);
    }

}
