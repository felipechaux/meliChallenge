package com.meli.android.meliproductapp.requestmanager

import com.meli.android.meliproductapp.domain.ProductEntity

fun ProductResponseServer.toProductDomainList(): List<ProductEntity> = results.map {
    it.run {
        ProductEntity(
            id,
            title,
            price
        )
    }
}
