package br.com.iupp.apivenda.subscriber

import br.com.iupp.apivenda.Model.EventInformation
import br.com.iupp.apivenda.controller.dto.SaleRequest
import br.com.iupp.apivenda.service.SaleService
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject

@NatsListener
class SaleSubscriber(val service:SaleService) {

    @Subject("event.product")
    fun getMessage(@Body eventInformation: EventInformation){

        when (eventInformation.event.event){
            "SAVE_SALE"->service.saveSale(SaleRequest(eventInformation.sale?.productId, eventInformation.sale?.qty)            )
            "DELETE_SALE"->service.deleteSale(eventInformation.saleId!!)
            else -> println("UNKNOW MESSAGE")

        }
    }
}