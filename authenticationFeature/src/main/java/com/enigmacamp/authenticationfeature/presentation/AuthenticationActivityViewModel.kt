package com.enigmacamp.authenticationfeature.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enigmacamp.authenticationfeature.data.api.request.AuthenticationRequest
import com.enigmacamp.authenticationfeature.data.repository.AuthenticationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthenticationActivityViewModel(
    private val authenticationRepository: AuthenticationRepository,
) : ViewModel() {
    private var _isAuthenticated = MutableLiveData<Boolean>()
    val isAuthenticated: LiveData<Boolean>
        get() = _isAuthenticated

    fun customerLogin(userName: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val isAuthenticated =
                authenticationRepository.login(
                    AuthenticationRequest(
                        userName,
                        password
                    )
                )
            if (isAuthenticated) {
                _isAuthenticated.postValue(true)
            } else {
                _isAuthenticated.postValue(false)
            }
        }
    }
}