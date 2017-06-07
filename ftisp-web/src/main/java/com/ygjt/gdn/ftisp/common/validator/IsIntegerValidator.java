package com.ygjt.gdn.ftisp.common.validator;

import com.ygjt.gdn.ftisp.common.annotation.IsInteger;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 整数校验类
 * Created by linx on 2016/11/15.
 */
public class IsIntegerValidator implements ConstraintValidator<IsInteger, String> {
    private boolean notNullStr;

    @Override
    public void initialize(IsInteger isInteger) {
        this.notNullStr = isInteger.notNull();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        //notNull:true 为空需要校验
        if (notNullStr&&StringUtils.isBlank(value)){
                return false;
        }
        //notNull:false 为空直接跳过校验
        if (!notNullStr&&StringUtils.isBlank(value)){
            return true;
        }
        //验证数字的正则表达式
        Pattern pattern = Pattern.compile("[0-9]+");
        return pattern.matcher(value).matches();
    }


}
