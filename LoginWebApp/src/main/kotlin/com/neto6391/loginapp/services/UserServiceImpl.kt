package com.neto6391.loginapp.services

import com.neto6391.loginapp.data.model.Role
import com.neto6391.loginapp.data.model.User
import com.neto6391.loginapp.repositories.RoleRepository
import com.neto6391.loginapp.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
        @Autowired private val userRepository: UserRepository,
        @Autowired private val roleRepository: RoleRepository,
        @Autowired private val bCryptPasswordEncoder: BCryptPasswordEncoder
) : UserService {

    override fun save(user: User?) {
        user?.setPassword(bCryptPasswordEncoder.encode(user.getPassword()))
        user?.setRoles(HashSet<Role>(roleRepository.findAll()))
        if (user != null) {
            userRepository.save(user)
        }
    }

    override fun findByUsername(username: String?): User? {
        return userRepository.findByUsername(username)
    }
}