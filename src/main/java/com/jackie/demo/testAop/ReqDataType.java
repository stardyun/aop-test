package com.jackie.demo.testAop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author Jackie
 * @Date 2020/6/25 00:56
 * @Description
 */
@Target({ElementType.PARAMETER})
public @interface ReqDataType {

    Class<?> value() default Object.class;
}
