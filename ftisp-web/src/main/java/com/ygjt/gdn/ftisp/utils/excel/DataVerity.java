package com.ygjt.gdn.ftisp.utils.excel;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by wyh on 2016/11/3.
 */
public class DataVerity {
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    public static String validator(Object entity){
        String msg = "";
        Set<ConstraintViolation<Object>> set = validator.validate(entity);
        for (ConstraintViolation<Object> constraintViolation : set){
            msg += constraintViolation.getMessage() + " | ";
        }
        return msg;
    }
}
