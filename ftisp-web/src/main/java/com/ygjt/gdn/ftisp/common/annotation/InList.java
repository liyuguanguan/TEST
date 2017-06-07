package com.ygjt.gdn.ftisp.common.annotation;


import com.ygjt.gdn.ftisp.common.validator.InListValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Je on 2016/11/2.
 */
@Constraint(validatedBy = {InListValidator.class})
@Documented
@Target( { ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface InList {
    String[] fields() default {""};
    String message() default "状态不正确";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
