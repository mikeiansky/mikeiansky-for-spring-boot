package io.github.mikeiansky.sample.sb.webflux.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;
import reactor.util.context.Context;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
//                .doOnError(new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) {
//                        System.out.println("on error : " + throwable);
//                    }
//                })
                .doFinally(new Consumer<SignalType>() {
                    @Override
                    public void accept(SignalType signalType) {
                        System.out.println("complete signal type : " + signalType);
                        Instant completeTime = Instant.now();
//                        System.out.println(startTime.getNano());
//                        System.out.println(startTime.getEpochSecond());
//                        System.out.println(completeTime.getNano());
//                        System.out.println(completeTime.getLong(ChronoField.DAY_OF_YEAR));
//                        System.out.println(completeTime.getLong(ChronoField.MICRO_OF_DAY));
                        System.out.println("use second time : " + (completeTime.getEpochSecond()- startTime.getEpochSecond()));
//                        System.out.println("use nano time : " + (completeTime.getNano()- startTime.getNano()));
                        System.out.println("MyInterceptor ::: =====> completeTime " + completeTime);
                    }
                });
    }
}
