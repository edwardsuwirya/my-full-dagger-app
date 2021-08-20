package com.enigmacamp.myfulldaggerapp.data.repository

import com.enigmacamp.myfulldaggerapp.data.api.request.AuthenticationRequest


interface AuthenticationRepository {
    suspend fun login(authenticationRequest: AuthenticationRequest): Boolean
    fun retrieveToken(): String?
}