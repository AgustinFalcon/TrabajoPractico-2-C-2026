package com.ifts4.trabajopractico2docuatrimestre2026.fragments

import androidx.core.util.PatternsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {

    //var viewState = MutableLiveData<SecondStateEnum>()
    var viewState = MutableLiveData<SecondStateSealed>()
    private var email = ""
    private var password = ""

    fun validateEmail(email: String) {
        this.email = email
        if (email.isNotBlank() && PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) {
            viewState.value = SecondStateSealed.SuccessEmail
        } else {
            viewState.value = SecondStateSealed.ErrorEmail
        }
        validateButton()
    }

    fun validatePassword(password: String) {
        this.password = password
        if (password.isNotBlank() && password.length >= 4) {
            viewState.value = SecondStateSealed.SuccessPassword

        } else {
            viewState.value = SecondStateSealed.ErrorPassword(password = password)
        }
        validateButton()
    }

    fun validateButton() {
        if (email.isNotBlank() && PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
            && password.isNotBlank() && password.length >= 4) {

            viewState.value = SecondStateSealed.SuccessButton
        } else {
            viewState.value = SecondStateSealed.ErrorButton
        }
    }
}

enum class SecondStateEnum {
    SUCCESS_EMAIL,
    ERROR_EMAIL,
    SUCCESS_PASSWORD,
    ERROR_PASSWORD,
    ERROR_BUTTON,
    SUCCESS_BUTTON
}

sealed class SecondStateSealed {
    object SuccessEmail: SecondStateSealed()
    object ErrorEmail: SecondStateSealed()
    object SuccessPassword: SecondStateSealed()
    data class ErrorPassword(val password: String): SecondStateSealed()
    object SuccessButton: SecondStateSealed()
    object ErrorButton: SecondStateSealed()
}

