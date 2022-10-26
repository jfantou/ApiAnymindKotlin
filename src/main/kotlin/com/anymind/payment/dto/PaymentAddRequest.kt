package com.anymind.payment.dto

import com.anymind.payment.enums.PaymentMethodEnum
import lombok.Getter
import lombok.Setter
import java.time.LocalDateTime

@Getter
@Setter
data class PaymentAddRequest(val price:String, val price_modifier:Double, val payment_method: String, val datetime: LocalDateTime)
