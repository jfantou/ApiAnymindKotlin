package com.anymind.payment.transformer

import com.anymind.payment.domain.Payment
import com.anymind.payment.dto.PaymentAddRequest
import com.anymind.payment.enums.PaymentMethodEnum
import org.springframework.stereotype.Component

@Component
class PaymentAddRequestToPaymentTransformer: Transformer<PaymentAddRequest, Payment> {

    override fun transform(source: PaymentAddRequest): Payment {
        return Payment(
                price = source.price.toDouble(),
                priceModifier = source.price_modifier,
                paymentMethod = source.payment_method,
                datetime =  source.datetime,
                finalPrice =  source.price_modifier*source.price.toDouble(),
                points = source.price.toDouble() * PaymentMethodEnum.valueOf(source.payment_method).pointModifier
        )
    }
}