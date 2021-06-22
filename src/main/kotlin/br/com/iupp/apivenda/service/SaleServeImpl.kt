package br.com.iupp.apivenda.service

import br.com.iupp.apivenda.controller.dto.SaleRequest
import br.com.iupp.apivenda.controller.mapper.Mapper
import br.com.iupp.apivenda.repository.SaleRepository
import java.util.*
import javax.inject.Singleton

@Singleton
class SaleServeImpl(val repository: SaleRepository): SaleService {

    override fun saveSale(saleRequest: SaleRequest) {
        repository.saveSale(Mapper.toSaleEntity(saleRequest))
    }

    override fun deleteSale(saleId: UUID) {
        repository.deleteSale(saleId = saleId)
    }
}
