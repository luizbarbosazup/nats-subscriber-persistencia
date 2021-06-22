package br.com.iupp.apivenda.controller.dto

import io.micronaut.core.annotation.Introspected
import java.util.*
import javax.validation.constraints.Positive

@Introspected
data class SaleRequest (
    val productId:UUID,
    @field:Positive val qty:Double)