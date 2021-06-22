package br.com.iupp.apivenda.service

import br.com.iupp.apivenda.controller.dto.SaleRequest
import java.util.*
import javax.inject.Singleton

@Singleton
interface SaleService {
    fun saveSale(saleRequest: SaleRequest)
    fun deleteSale(saleId: UUID)
}