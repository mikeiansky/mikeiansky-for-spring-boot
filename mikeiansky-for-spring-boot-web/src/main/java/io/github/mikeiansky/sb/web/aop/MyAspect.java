package io.github.mikeiansky.sb.web.aop;

import io.github.mikeiansky.sb.web.exception.BizException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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

    @Pointcut("execution(public * io.github.mikeiansky.sb.web.controller.*.*(..))")
    public void anyPublic() {
        System.out.println("use any public");
    }

    @Before("anyPublic()")
    public void beforeAnyPublic() {
        System.out.println("beforeAnyPublic xxxxx ");
    }

    @AfterThrowing(pointcut = "anyPublic()", throwing = "e")
    public void afterException(JoinPoint joinPoint, BizException e) {
        // 异常处理逻辑
        System.out.println("throw exception ........... joinPoint : " + joinPoint);
        System.out.println("throw exception ........... ex : " + e);
    }

}
