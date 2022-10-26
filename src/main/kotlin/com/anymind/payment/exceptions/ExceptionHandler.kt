package com.anymind.payment.exceptions

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(JsonParseException:: class)
    fun exceptionHandler(exception: Exception): ResponseEntity<ApiError>{
        val error = ApiError("Data in the JSON is not correct (Date, String, Integer, Double)")
        return ResponseEntity(error, error.status)
    }
}