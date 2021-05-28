package com.manuflowers.domain.utils

sealed class Result<out R>

data class Success<out SuccessData>(val data: SuccessData): Result<SuccessData>()
data class Error(
    val message: String = "",
    val internalCode: String = ""
): Result<Nothing>()