package com.enigmacamp.authenticationfeature.data.repository

import com.enigmacamp.authenticationfeature.data.api.request.AuthenticationRequest


interface AuthenticationRepository {
    suspend fun login(authenticationRequest: AuthenticationRequest): Boolean
    fun retrieveToken(): String?
}