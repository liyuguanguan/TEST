package com.ygjt.gdn.ftisp.common.validator;

import com.ygjt.gdn.ftisp.common.annotation.IsDate;
import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;

/**
 * 日期校验类
 * Created by linx on 2016/11/15.
 */
public class IsDateValidator implements ConstraintValidator<IsDate, String> {
    private String formatStr;

    @Override
    public void initialize(IsDate isDate) {
        this.formatStr = isDate.format();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        boolean convertSuccess = true;
        //为空不校验
        if (StringUtils.isBlank(value)) {
            return convertSuccess;
        }
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(value);
        } catch (Exception e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }
}
