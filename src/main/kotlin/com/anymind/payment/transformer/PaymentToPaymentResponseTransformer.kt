package com.anymind.payment.transformer

import com.anymind.payment.domain.Payment
import com.anymind.payment.dto.PaymentResponse
import org.springframework.stereotype.Component

@Component
class PaymentToPaymentResponseTransformer: Transformer<Payment, PaymentResponse> {

    override fun transform(source: Payment): PaymentResponse {
        return PaymentResponse(
                source.finalPrice.toString(),
                source.points
        )
    }
}