package com.anymind.payment.ressources

import com.anymind.payment.domain.Payment
import com.anymind.payment.dto.CalculateSales
import com.anymind.payment.dto.GetSalesRequest
import com.anymind.payment.dto.PaymentAddRequest
import com.anymind.payment.dto.PaymentResponse
import com.anymind.payment.ressources.PaymentResource.Companion.BASE_PAYMENT_URL
import com.anymind.payment.service.PaymentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.net.URI

@RestController
@RequestMapping(value = [BASE_PAYMENT_URL])
class PaymentResource(private val paymentService: PaymentService) {

    @PostMapping
    fun save(@RequestBody paymentRequest: PaymentAddRequest): ResponseEntity<PaymentResponse> {
            val paymentResponse= paymentService.save(paymentRequest)
            return ResponseEntity(paymentResponse, HttpStatus.CREATED)
    }

    @GetMapping
    fun findAll(): List<Payment> {
        return paymentService.getPayments();
    }

    @GetMapping
    @RequestMapping("/calculateSales")
    fun calculateSales(@RequestBody getSalesRequest: GetSalesRequest): ResponseEntity<List<CalculateSales>>{
        var rst = paymentService.calculateSales(getSalesRequest.startDateTime, getSalesRequest.endDateTime)
        return ResponseEntity
                .created(URI.create(BASE_PAYMENT_URL))
                .body(rst)
    }

    companion object {
        const val BASE_PAYMENT_URL: String = "/api/v1/payment"
    }
}