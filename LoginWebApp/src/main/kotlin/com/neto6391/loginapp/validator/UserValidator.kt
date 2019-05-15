package com.neto6391.loginapp.validator

import com.neto6391.loginapp.data.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Validator
import com.neto6391.loginapp.services.UserService


@Component
class UserValidator : Validator {
    @Autowired
    private val userService: UserService? = null

    override fun supports(aClass: Class<*>): Boolean {
        return User::class.java == aClass
    }

    override fun validate(o: Any, errors: Errors) {
        val user = o as User?


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty")
        if ((user?.getUsername()!!.length < 6) || user.getUsername()!!.length > 32) {
            errors.rejectValue("username", "Size.userForm.username")
        }
        if (userService?.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username")
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty")
        if (user?.getPassword()!!.length < 6 || user.getPassword()!!.length > 32) {
            errors.rejectValue("password", "Size.userForm.password")
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm")
        }
    }
}