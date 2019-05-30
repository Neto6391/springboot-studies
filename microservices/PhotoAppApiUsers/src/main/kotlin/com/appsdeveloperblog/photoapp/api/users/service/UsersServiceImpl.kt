package com.appsdeveloperblog.photoapp.api.users.service

import com.appsdeveloperblog.photoapp.api.users.data.UserEntity
import com.appsdeveloperblog.photoapp.api.users.data.UsersRepository
import com.appsdeveloperblog.photoapp.api.users.shared.UserDto
import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsersServiceImpl(
        private val usersRepository: UsersRepository
) : UsersService {
    override fun createUsers(userDetails: UserDto): UserDto {
        //Generate Random Unique User Id
        userDetails.setUserId(UUID.randomUUID().toString())

        //Map UserDto to UserEntity
        val modelMapper = ModelMapper()

        //Set Config Strategy to mapper
        modelMapper.configuration.matchingStrategy = MatchingStrategies.STRICT

        val userEntity = modelMapper.map(userDetails, UserEntity::class.java)
        userEntity.setEncriptedPassword("test")

        //Save data in db
        usersRepository.save(userEntity)

        val returnValue = modelMapper.map(userEntity, UserDto::class.java)

        return returnValue
    }

}