package com.ygjt.gdn.ftisp.common.annotation;


import com.ygjt.gdn.ftisp.common.validator.IsDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 时间注解类
 * Created by linx on 2016/11/15.
 */
@Constraint(validatedBy = {IsDateValidator.class})
@Documented
@Target( { ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsDate {
    String format() default "yyyy-MM-dd HH:mm:ss";

    String message() default "时间格式不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
