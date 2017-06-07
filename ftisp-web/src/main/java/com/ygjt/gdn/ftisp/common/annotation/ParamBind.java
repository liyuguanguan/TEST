package com.ygjt.gdn.ftisp.common.annotation;

import org.springframework.web.bind.annotation.ValueConstants;

import java.lang.annotation.*;

/**
 * Created by heavenick on 2016/5/17.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamBind {
    /**
     * The name of the request parameter to bind to.
     */
    String value() default "";

    boolean required() default false;

    String defaultValue() default ValueConstants.DEFAULT_NONE;
}
