package com.anymind.payment.dao

import com.anymind.payment.domain.Payment
import com.anymind.payment.dto.CalculateSales
import com.anymind.payment.dto.PaymentAddRequest
import com.anymind.payment.dto.PaymentResponse
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Repository
@Transactional
interface SalesDao: JpaRepository<Payment, Long> {

    @Query("SELECT new com.anymind.payment.dto.CalculateSales(datetime, SUM(finalPrice), SUM(points))" +
            "FROM Payment " +
            "GROUP BY datetime")
    fun calculateSalesBydate(): List<CalculateSales>
}