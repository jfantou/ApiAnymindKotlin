package com.anymind.payment.enums

enum class PaymentMethodEnum(val pointModifier: Double) {
    CASH(0.05),
    CASH_ON_DELIVERY(0.05),
    VISA(0.03),
    MASTERCARD(0.03),
    AMEX(0.02),
    JCB(0.05);
}