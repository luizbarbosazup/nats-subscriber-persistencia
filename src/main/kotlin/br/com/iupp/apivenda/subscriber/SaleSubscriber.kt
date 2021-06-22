package br.com.iupp.apivenda.subscriber

import br.com.iupp.apivenda.Model.EventListener
import br.com.iupp.apivenda.Model.SaleEntity
import br.com.iupp.apivenda.controller.dto.SaleRequest
import br.com.iupp.apivenda.service.SaleService
import io.micronaut.http.annotation.Body
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject

@NatsListener
class SaleSubscriber(val service:SaleService) {

    @Subject("event.product")
    fun getMessage(@Body eventListener: EventListener){

        when (eventListener.event.event){
            "SAVE_SALE"->service.saveSale(SaleRequest(eventListener.sale.productId,eventListener.sale.qty))
//            "DELETE_SALE"->service.saveSale(SaleRequest(eventListener.sale.productId,eventListener.sale.qty))

        }
    }
}