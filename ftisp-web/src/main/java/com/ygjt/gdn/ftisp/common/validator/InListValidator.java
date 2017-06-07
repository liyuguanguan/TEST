package com.ygjt.gdn.ftisp.common.validator;


import com.ygjt.gdn.ftisp.common.annotation.InList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Created by Je on 2016/11/2.
 * 校验类，校验值是否在指定列表中
 */
public class InListValidator implements ConstraintValidator<InList, String> {

    private String[] values;
    @Override
    public void initialize(InList inList) {
        this.values = inList.fields();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        value = value==null?"null":value;
        if(Arrays.asList(values).contains(value))
            return true;
        return false;
    }
}
