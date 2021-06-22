package br.com.iupp.apivenda.repository

import br.com.iupp.apivenda.Model.SaleEntity
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.ResultSet
import com.datastax.oss.driver.api.core.cql.Row
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.*
import javax.inject.Singleton

@Singleton
class SaleRepositoryImpl(val cqlSession: CqlSession):SaleRepository {

    private fun verifyExistsProduct(productId:UUID):Boolean{

        var result:ResultSet = cqlSession.execute(
            SimpleStatement
                .newInstance("SELECT * FROM pdvdata.product WHERE id = ?", productId)
        )

        val isProduct: Row? = result.one()
        if (isProduct != null) {
            println("PRODUTO ENCONTRADO : CÓDIGO ${isProduct.getUuid("id")} DESCRICAO : ${isProduct.getString("name")}")
            return  true
        }
        println("ATENÇÃO : PRODUTO NÃO ENCONTRADO. VENDA CANCELADA")
        return false

    }

    override fun saveSale(saleEntity: SaleEntity) {

//        if (!verifyExistsProduct(saleEntity.productId)){
//            return
//        }

        cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "INSERT INTO pdvdata.sale(id,productid,qty) values (?,?,?)",
                    UUID.randomUUID(),
                    saleEntity.productId,
                    saleEntity.qty
                )
        )
        println("VENDA EFETUADA!!!")
    }
}