package com.neto6391.loginapp.web

import com.neto6391.loginapp.data.model.User
import com.neto6391.loginapp.services.SecurityService
import com.neto6391.loginapp.services.UserService
import com.neto6391.loginapp.validator.UserValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping


@Controller
class UserController {
    @Autowired
    private val userService: UserService? = null

    @Autowired
    private val securityService: SecurityService? = null

    @Autowired
    private val userValidator: UserValidator? = null

    @GetMapping("/registration")
    fun registration(model: Model): String {
        model.addAttribute("userForm", User())

        return "registration"
    }

    @PostMapping("/registration")
    fun registration(@ModelAttribute("userForm") userForm: User, bindingResult: BindingResult): String {
        if (userValidator != null) {
            userValidator.validate(userForm, bindingResult)
        }

        if (bindingResult.hasErrors()) {
            return "registration"
        }

        if (userService != null) {
            userService.save(userForm)
        }

        if (securityService != null) {
            securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm())
        }

        return "redirect:/welcome"
    }

    @GetMapping("/login")
    fun login(model: Model, error: String?, logout: String?): String {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.")

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.")

        return "login"
    }

    @GetMapping("/", "/welcome")
    fun welcome(model: Model): String {
        return "welcome"
    }
}