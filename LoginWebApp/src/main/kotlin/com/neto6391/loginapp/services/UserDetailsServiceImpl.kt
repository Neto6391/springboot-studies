package com.neto6391.loginapp.services

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.HashSet
import com.neto6391.loginapp.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional


@Service
class UserDetailsServiceImpl : UserDetailsService {
    @Autowired
    private val userRepository: UserRepository? = null

    @Transactional(readOnly = true)
    override fun loadUserByUsername(username: String?): UserDetails? {
        val user = userRepository?.findByUsername(username)
        val grantedAuthorities = HashSet<GrantedAuthority>()
        if (user != null) {
            for (role in user.getRoles()!!) {
                grantedAuthorities.add(SimpleGrantedAuthority(role.getName()))
            }
        }

        return org.springframework.security.core.userdetails.User(user?.getUsername(), user?.getPassword(), grantedAuthorities)
    }
}