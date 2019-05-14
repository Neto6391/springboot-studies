package com.neto6391.restappdb.security.jwt

import com.neto6391.restappdb.exceptions.exception.InvalidJwtAuthenticationException
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.PostConstruct
import javax.servlet.http.HttpServletRequest

@Service
class JwtTokenProvider(var userDetailsService:UserDetailsService) {

    var secretKey:String = "secret"
    var validityInMiliseconds = 3600000 //1H

    //After is done the injection of dependency going inject the secret key
    @PostConstruct
    fun init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.toByteArray())
    }

    fun createToken(username:String, roles:List<String>):String {
        //Certificator
        val claims:Claims = Jwts.claims().setSubject(username)
        //define roles of user
        claims.put("roles", roles)

        val now = Date()
        val validity = Date(now.time + validityInMiliseconds)

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact()
    }

    //Get token, found user present in token in userDetails read user and return authentication of user name authentication token.
    fun getAuthentication(token:String):Authentication {
        val userDetails:UserDetails = userDetailsService.loadUserByUsername(getUsername(token))
        return UsernamePasswordAuthenticationToken(userDetails,"", userDetails.authorities)
    }

    private fun getUsername(token: String): String {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).body.subject
    }


    fun resolveToken(req:HttpServletRequest): String? {
        //Search for Request Header
        val bearerToken = req.getHeader("Authorization")
        if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
            //Bearer kdaksdkaskdaksd... Example
            return bearerToken.substring(7, bearerToken.length)
        }
        return null
    }

    fun validateToken(token:String):Boolean {
        try {
            val claims: Jws<Claims> = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
            if(claims.body.expiration.before(Date())) {
                return false
            }
            return true
        } catch (e:Exception) {
            throw InvalidJwtAuthenticationException("Expired or invalid Token")
        }
    }

}