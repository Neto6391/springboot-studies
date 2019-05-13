package com.neto6391.restappdb.config

import com.neto6391.restappdb.security.jwt.JwtConfigurer
import com.neto6391.restappdb.security.jwt.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class SecurityConfig(private val tokenProvider: JwtTokenProvider) : WebSecurityConfigurerAdapter() {

    //Encrypt of password use this Algorithm
    /**
     * Example
     *
     * val bCryptPasswordEncoder:BCryptPasswordEncoder = BCryptPasswordEncoder(16)
     * val result:String = bCryptPasswordEncoder.encode("admin123")
     * println("My Hash $result")
     * */
    @Bean
    fun passwordEnconder(): BCryptPasswordEncoder {
        val bCryptPasswordEncoder:BCryptPasswordEncoder = BCryptPasswordEncoder()
        return bCryptPasswordEncoder
    }

    @Bean
    override fun authenticationManagerBean():AuthenticationManager {
        return super.authenticationManagerBean()
    }

    //Config application
    protected override fun configure(http:HttpSecurity) {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/auth/signin", "/api-docs/**", "swagger-ui.html**").permitAll() //Permits urls
                .antMatchers("/api/**").authenticated()
                .antMatchers("/users").denyAll()
                .and()
                .apply(JwtConfigurer(tokenProvider))
    }



}