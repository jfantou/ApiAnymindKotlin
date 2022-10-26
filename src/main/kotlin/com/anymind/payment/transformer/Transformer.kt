package com.anymind.payment.transformer

interface Transformer <A,B> {
    fun transform (source: A): B
}