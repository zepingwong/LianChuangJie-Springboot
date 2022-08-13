package com.lianchuangjie.lianchuangjie.utils.validate;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class NotEqualValidator implements ConstraintValidator<NotEqual, String> {
    String patten = "";
    @Override
    public void initialize(NotEqual constraintAnnotation) {
        //获取注解上的值，可以做一写取注解上的值做一下判断
        patten = constraintAnnotation.patten();
    }
    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(s)) {
            return false;
        }

        return validate(s);
    }

    /**
     * 校验方法，校验规则
     *
     * @param s 值
     * @return 是否符合规则，true通过，false不通过
     */
    private boolean validate(String s) {
        return !Objects.equals(s, patten);
    }
}
