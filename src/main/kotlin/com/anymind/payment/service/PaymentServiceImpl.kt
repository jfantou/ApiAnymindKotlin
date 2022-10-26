package com.anymind.payment.service

import com.anymind.payment.dao.SalesDao
import com.anymind.payment.domain.Payment
import com.anymind.payment.dto.CalculateSales
import com.anymind.payment.dto.PaymentAddRequest
import com.anymind.payment.dto.PaymentResponse
import com.anymind.payment.transformer.PaymentToPaymentResponseTransformer
import com.anymind.payment.transformer.PaymentAddRequestToPaymentTransformer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*

@Service
class PaymentServiceImpl(@Autowired private val salesDao: SalesDao,
                         private val paymentAddRequestToPaymentTransformer: PaymentAddRequestToPaymentTransformer,
                         private val paymentToPaymentResponseTransformer: PaymentToPaymentResponseTransformer): PaymentService {
    override fun calculateSales(startDate: LocalDateTime, endDate: LocalDateTime): List<CalculateSales> {
        var rst = salesDao.calculateSalesBydate()
        return rst
    }

    @Transactional
    override fun save(paymentRequest: PaymentAddRequest): PaymentResponse {
        var payment = paymentAddRequestToPaymentTransformer.transform(paymentRequest)
        var paymentSave = salesDao.saveAndFlush(payment)
        var paymentResponse = paymentToPaymentResponseTransformer.transform(paymentSave)
        return paymentResponse
    }

    override fun getPayments(): List<Payment>{
        return salesDao.findAll()
    }
}