package com.ygjt.gdn.ftisp.common.validator;

import com.ygjt.gdn.ftisp.common.annotation.IsDouble;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 小数校验类
 * Created by linx on 2016/11/15.
 */
public class IsDoubleValidator implements ConstraintValidator<IsDouble, String> {
    private boolean notNullStr;

    @Override
    public void initialize(IsDouble isDouble) {
        this.notNullStr = isDouble.notNull();
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
        Pattern pattern = Pattern.compile("(([0-9]|([1-9][0-9]+))(\\.[0-9]{1,4}))|([1-9])|([1-9][0-9]+)");
        return pattern.matcher(value).matches();
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(([0-9]|([1-9][0-9]+))(\\.[0-9]{1,4}))|([1-9])|([1-9][0-9]+)");
        System.out.println(pattern.matcher("1.1").matches());
        System.out.println(pattern.matcher("0.1").matches());
        System.out.println(pattern.matcher("1").matches());
        System.out.println(pattern.matcher(".1").matches());
        System.out.println(pattern.matcher("1a").matches());
        System.out.println(pattern.matcher("1.1.1").matches());
    }

}
