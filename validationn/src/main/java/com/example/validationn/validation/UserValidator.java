package com.example.validationn.validation;

import com.example.validationn.bean.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(!(target instanceof User)) return;
        User user = (User) target;
        if(!user.getPhone().matches("^0[0-9]{9}$")) {
            errors.rejectValue("phone", "phone", "Số điện thoại không đúng định dạng");
        }
    }
    }
