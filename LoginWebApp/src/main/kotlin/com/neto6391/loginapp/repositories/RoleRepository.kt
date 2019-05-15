package com.neto6391.loginapp.repositories

import com.neto6391.loginapp.data.model.Role
import com.neto6391.loginapp.data.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Long>