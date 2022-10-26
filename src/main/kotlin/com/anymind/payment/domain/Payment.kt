package com.anymind.payment.domain

import com.anymind.payment.enums.PaymentMethodEnum
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.time.LocalDateTime
import javax.persistence.*

@Getter
@Setter
@Entity
@Table(name="payment")
data class Payment(
        @Id
        @SequenceGenerator(name= PAYMENT_SEQUENCE, sequenceName=PAYMENT_SEQUENCE, initialValue = 1, allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = PAYMENT_SEQUENCE)
        val id:Long? = null,
        @Column(name="price")
        val price:Double,
        @Column(name="price_modifier")
        val priceModifier:Double,
        @Column(name="payment_method")
        val paymentMethod: String,
        @Column(name="datetime")
        val datetime:LocalDateTime,
        @Column(name="final_price")
        val finalPrice:Double,
        @Column(name="points")
        val points:Double){

    companion object {
        const val PAYMENT_SEQUENCE: String = "PAYMENT_SEQUENCE"
    }
}
