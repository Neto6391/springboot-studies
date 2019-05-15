package com.neto6391.loginapp.services

interface SecurityService {
    fun findLoggedInUsername(): String?
    fun autoLogin(username: String?, password: String?)
}