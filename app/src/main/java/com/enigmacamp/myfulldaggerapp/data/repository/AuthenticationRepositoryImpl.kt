package com.enigmacamp.myfulldaggerapp.data.repository

import com.enigmacamp.myfulldaggerapp.data.SharedPref
import com.enigmacamp.myfulldaggerapp.data.api.AuthApi
import com.enigmacamp.myfulldaggerapp.data.api.request.AuthenticationRequest

class AuthenticationRepositoryImpl(
    private val authApi: AuthApi,
    private val sharedPref: SharedPref
) :
    AuthenticationRepository {
    override suspend fun login(authenticationRequest: AuthenticationRequest): Boolean {
        val response = authApi.login(authenticationRequest)
        if (response.isSuccessful) {
            response.body()?.let {
//                Log.d("Repo", "loginRes: ${it.token}")
                sharedPref.save(TOKEN, it.token)
                return true
            }
            return false
        }
        return false
    }

    override fun retrieveToken(): String? {
        return sharedPref.retrived(TOKEN)
    }

    companion object {
        private const val TOKEN = "token"
    }
}