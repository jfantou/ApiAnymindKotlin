package com.anymind.payment.dto

import java.time.LocalDateTime

data class GetSalesRequest(val startDateTime:LocalDateTime, val endDateTime:LocalDateTime) {
}