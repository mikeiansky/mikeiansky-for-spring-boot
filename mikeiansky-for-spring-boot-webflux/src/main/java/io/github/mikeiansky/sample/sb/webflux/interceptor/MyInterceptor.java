package io.github.mikeiansky.sample.sb.webflux.interceptor;

import io.github.mikeiansky.sample.sb.webflux.exception.BizException;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.function.Consumer;

/**
 * @author mike ian
 * @date 2025/6/14
 * @desc
 **/
@Component
public class MyInterceptor implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        Instant startTime = Instant.now();
        System.out.println("MyInterceptor ::: =====> startTime " + startTime);
        exchange.getRequest().getAttributes().put("hello", "world");
        return chain.filter(exchange)
//                .contextWrite(Context.of("userId", "9527"))
                .onErrorResume(ex -> {
                    if (ex instanceof BizException be){
                        System.out.println("be.getMessage() : " + be.getMessage());
                        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
                        DataBuffer buffer = exchange.getResponse()
                                .bufferFactory()
                                .wrap(be.getMessage().getBytes(StandardCharsets.UTF_8));
                        return exchange.getResponse().writeWith(Mono.just(buffer));
                    }
                    System.out.println("handle error : " + ex);
                    return Mono.error(ex);
                })
                .doFinally(new Consumer<SignalType>() {
                    @Override
                    public void accept(SignalType signalType) {
                        System.out.println("complete signal type : " + signalType);
                        Instant completeTime = Instant.now();
                        System.out.println("use second time : " + (completeTime.getEpochSecond()- startTime.getEpochSecond()));
                        System.out.println("MyInterceptor ::: =====> completeTime " + completeTime);
                    }
                });
    }
}
