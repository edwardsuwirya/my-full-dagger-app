package com.enigmacamp.authenticationfeature.data.repository

import com.enigmacamp.authenticationfeature.data.api.AuthApi
import com.enigmacamp.authenticationfeature.data.api.request.AuthenticationRequest
import com.enigmacamp.core.data.SharedPref
import com.enigmacamp.core.data.db.AppDatabase
import com.enigmacamp.core.data.entity.Customer
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val authApi: AuthApi,
    private val db: AppDatabase,
    private val sharedPref: SharedPref
) :
    AuthenticationRepository {
    override suspend fun login(authenticationRequest: AuthenticationRequest): Boolean {
        val response = authApi.login(authenticationRequest)
        if (response.isSuccessful) {
            response.body()?.let {
//                Log.d("Repo", "loginRes: ${it.token}")
                sharedPref.save(TOKEN, it.token)
                db.customerDao().insert(
                    Customer(
                        name = authenticationRequest.userName,
                        idCard = "123",
                        gender = "L"
                    )
                )
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