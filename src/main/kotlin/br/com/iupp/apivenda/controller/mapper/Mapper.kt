package br.com.iupp.apivenda.controller.mapper

import br.com.iupp.apivenda.Model.SaleEntity
import br.com.iupp.apivenda.controller.dto.SaleRequest
import java.util.*
import javax.inject.Singleton

@Singleton
class Mapper {

    companion object{
        fun toSaleEntity(saleRequest: SaleRequest)=
            SaleEntity(saleRequest.productId,saleRequest.qty)

        fun toSaleRequest(saleEntity: SaleEntity)=
             SaleRequest(saleEntity.productId,saleEntity.qty)

    }


}