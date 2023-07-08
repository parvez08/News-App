package com.droid.smart_staff.newsapp.utils

data class GenericResponse<T>(val data: T?, val success: Boolean, val message: String?)