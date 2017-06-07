package com.ygjt.gdn.ftisp.common.annotation;


import com.ygjt.gdn.ftisp.common.validator.IsIntegerValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by linx on 2016/11/28.
 */
@Constraint(validatedBy = {IsIntegerValidator.class})
@Documented
@Target( { ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsInteger {
    boolean notNull() default true;

    String message() default "格式不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
