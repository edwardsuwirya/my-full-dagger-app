package com.enigmacamp.authenticationfeature.data.api

import com.enigmacamp.authenticationfeature.data.api.request.AuthenticationRequest
import com.enigmacamp.authenticationfeature.data.api.response.AuthenticationResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("login")
    suspend fun login(@Body authentication: AuthenticationRequest): Response<AuthenticationResponse>
}