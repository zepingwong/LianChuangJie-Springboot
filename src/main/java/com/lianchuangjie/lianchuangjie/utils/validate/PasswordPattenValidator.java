package com.lianchuangjie.lianchuangjie.utils.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class PasswordPattenValidator implements ConstraintValidator<PasswordPatten, String> {
    /**
     * 重写校验方法
     *
     * @param value   值
     * @param context 上下文
     * @return 是否校验通过，true通过，false不通过
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(value)) {
            return false;
        }
        return validatePassword(value);
    }

    /**
     * 校验方法，校验规则
     *
     * @param password 值
     * @return 是否符合规则，true通过，false不通过
     */
    private boolean validatePassword(String password) {
        return StringUtils.containsAny(password, "-_+=,.?~!@#$%^&*()")
                && StringUtils.containsAny(password, "abcdefghijklmnopqrstuvwxyz")
                && StringUtils.containsAny(password, "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
                && StringUtils.containsAny(password, "0123456789");
    }
}