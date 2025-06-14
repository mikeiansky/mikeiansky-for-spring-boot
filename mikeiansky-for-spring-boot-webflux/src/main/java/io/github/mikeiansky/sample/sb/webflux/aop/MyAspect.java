package io.github.mikeiansky.sample.sb.webflux.aop;

import io.github.mikeiansky.sample.sb.webflux.exception.BizException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SignalType;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author mike ian
 * @date 2025/6/14
 * @desc
 **/
@Component
@Aspect
public class MyAspect {

    public MyAspect() {
        System.out.println("create MyAspect");
    }

    @Pointcut("execution(public * io.github.mikeiansky.sample.sb.webflux.controller..*.*(..))")
    public void anyPublic() {
        System.out.println("use any public");
    }

    @AfterThrowing(pointcut = "anyPublic()", throwing = "e")
    public void afterException(JoinPoint joinPoint, BizException e) {
        // 异常处理逻辑
        System.out.println("throw exception ........... joinPoint : " + joinPoint);
        System.out.println("throw exception ........... ex : " + e);
    }

    @Before("anyPublic()")
    public void beforeAnyPublic(JoinPoint point) throws Throwable {
        System.out.println("beforeAnyPublic xxxxx point : " + point);
        System.out.println(point.getSignature().getName());
//        System.out.println(((MethodSignature)point.getSignature()).getMethod().getName());
//        System.out.println(((MethodSignature)point.getSignature()).getMethod().getParameters());
//        System.out.println(Arrays.stream(point.getArgs()).toList());

//        System.out.println(Arrays.stream(joinPoint.getArgs()).map(String::valueOf).toList());

//        Object result = joinPoint.proceed();
//        System.out.println("result : " + result);
//        System.out.println("result clazz : " + result.getClass());
//        if (result instanceof Mono<?> mr) {
//            System.out.println("result instanceof Mono<?>");
//            mr.doFinally(new Consumer<SignalType>() {
//                @Override
//                public void accept(SignalType signalType) {
//                    System.out.println("complete ......... ");
//                }
//            });
//        }

    }

}
