package com.anymind.payment.dto

import lombok.Getter
import lombok.Setter
import java.time.LocalDateTime

@Getter
@Setter
data class CalculateSales(val datetime: LocalDateTime, val sales:Double, val points:Double)
