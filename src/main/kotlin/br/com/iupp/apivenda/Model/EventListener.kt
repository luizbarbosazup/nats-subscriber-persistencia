package br.com.iupp.apivenda.Model

data class EventListener (
    val event:Events = Events.SAVE_SALE,
    val sale: SaleEntity
        )