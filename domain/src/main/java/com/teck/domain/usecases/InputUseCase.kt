package com.teck.domain.usecases

interface InputUseCase<T> {
    fun saveData(data: T)
}