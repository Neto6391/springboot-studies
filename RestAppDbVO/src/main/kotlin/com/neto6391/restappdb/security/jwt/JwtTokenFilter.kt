package com.neto6391.restappdb.security.jwt

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class JwtTokenFilter(private val tokenProvider:JwtTokenProvider) : GenericFilterBean() {



    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val token:String? = tokenProvider.resolveToken(request as HttpServletRequest)

        if(token != null && tokenProvider.validateToken(token)) {
            val auth:Authentication = tokenProvider.getAuthentication(token)
            if(auth != null) {
                //Go in Context and set Authentication
                SecurityContextHolder.getContext().authentication = auth
            }
        }

        chain?.doFilter(request, response)
    }

}