package br.com.iupp.apivenda.Model

import java.util.*

data class EventInformation (
    val event:Events = Events.SAVE_SALE,
    val sale: SaleEntity?,
    val saleId: UUID?
        )