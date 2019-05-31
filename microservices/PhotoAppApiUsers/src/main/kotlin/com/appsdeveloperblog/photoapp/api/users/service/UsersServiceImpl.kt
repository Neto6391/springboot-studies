package com.appsdeveloperblog.photoapp.api.users.service

import com.appsdeveloperblog.photoapp.api.users.data.UserEntity
import com.appsdeveloperblog.photoapp.api.users.data.UsersRepository
import com.appsdeveloperblog.photoapp.api.users.shared.UserDto
import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsersServiceImpl(
        @Autowired private val usersRepository: UsersRepository,
        @Autowired private val bCryptPasswordEncoder: BCryptPasswordEncoder
) : UsersService {
    override fun createUsers(userDetails: UserDto): UserDto {
        //Generate Random Unique User Id
        userDetails.setUserId(UUID.randomUUID().toString())

        //Encrypt password
        userDetails.setEncriptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()))

        //Map UserDto to UserEntity
        val modelMapper = ModelMapper()

        //Set Config Strategy to mapper
        modelMapper.configuration.matchingStrategy = MatchingStrategies.STRICT

        val userEntity = modelMapper.map(userDetails, UserEntity::class.java)

        //Save data in db
        usersRepository.save(userEntity)

        val returnValue = modelMapper.map(userEntity, UserDto::class.java)

        return returnValue
    }

}