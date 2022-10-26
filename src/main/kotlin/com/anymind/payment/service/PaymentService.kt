package com.anymind.payment.service

import com.anymind.payment.domain.Payment
import com.anymind.payment.dto.CalculateSales
import com.anymind.payment.dto.PaymentAddRequest
import com.anymind.payment.dto.PaymentResponse
import java.time.LocalDateTime

interface PaymentService {
    fun calculateSales(date1: LocalDateTime, date2: LocalDateTime): List<CalculateSales>
    fun save(paymentRequest: PaymentAddRequest): PaymentResponse
    fun getPayments(): List<Payment>
}