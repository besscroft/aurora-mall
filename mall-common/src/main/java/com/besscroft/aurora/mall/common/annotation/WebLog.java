package com.besscroft.aurora.mall.common.annotation;

import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解
 *
 * @Author Bess Croft
 * @Time 2021/7/18 16:35
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebLog {

    /**
     * 日志描述信息
     * @return
     */
    String description() default "";

}
