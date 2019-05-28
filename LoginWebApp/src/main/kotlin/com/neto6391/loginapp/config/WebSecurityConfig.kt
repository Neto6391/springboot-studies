package com.neto6391.loginapp.config

import com.neto6391.loginapp.security.AuthProviderService
import com.neto6391.loginapp.services.UserDetailsServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService

@Configuration
@EnableWebSecurity
class WebSecurityConfig() : WebSecurityConfigurerAdapter() {

//    @Autowired lateinit var userDetailsService: UserDetailsService
    @Autowired lateinit var authenticationProviderService: AuthProviderService

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }



    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests()
                .antMatchers("/resources/**", "/registration").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username").passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .permitAll()
    }

//    @Bean
//    @Throws(Exception::class)
//    fun CustomAuthenticationManager(): AuthenticationManager {
//        return CustomAuthenticationManager(bCryptPasswordEncoder())
//    }

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder())
        auth.authenticationProvider(authenticationProviderService)
    }

}