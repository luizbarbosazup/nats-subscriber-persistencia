package br.com.iupp.apivenda.repository

import br.com.iupp.apivenda.Model.SaleEntity
import java.util.*
import javax.inject.Singleton

@Singleton
interface SaleRepository {

    fun saveSale(saleEntity: SaleEntity)
    fun deleteSale(saleId: UUID)
}