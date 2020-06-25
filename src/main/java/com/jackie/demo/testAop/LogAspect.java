package com.jackie.demo.testAop;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ResolvableType;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 日志注解切面
 * @author Jackie
 */
@Slf4j
@ComponentScan("com.jackie")
@Aspect
@Configuration
public class LogAspect {

    /**
     * 继承了“BaseController”的RestController控制器方法
     */
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    public void restControllerMethodPointcut() {
    }


    @Around("restControllerMethodPointcut()")
    public Object interceptor(ProceedingJoinPoint pjPoint) throws Throwable {
        String aesKey = null;
        try {
            Signature signature = pjPoint.getSignature();
            for (Object arg : pjPoint.getArgs()) {
                if (arg instanceof BaseRequest) {
                    Class<?> clazz;
                    Type parameterizedType = ((MethodSignature) signature).getMethod().getParameters()[0].getParameterizedType();
                    ParameterizedType parameterizedType1 = (ParameterizedType) parameterizedType;
                    Type[] actualTypeArguments = parameterizedType1.getActualTypeArguments();
                    if (actualTypeArguments.length > 0) {
                        Type actualTypeArgument = actualTypeArguments[0];
                        clazz = Class.forName(actualTypeArgument.getTypeName());
                        BaseRequest baseRequest = (BaseRequest) arg;
                        System.out.println(clazz);
                    }
                }
            }
        } catch (Exception e) {
            log.info("请求发生错误：{}", e.getMessage());
        }
        Object response = pjPoint.proceed();
        return response;
    }

}
