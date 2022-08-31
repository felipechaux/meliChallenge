package com.meli.android.meliproductapp.requestmanager

import com.meli.android.meliproductapp.domain.AttributesEntity
import com.meli.android.meliproductapp.domain.ProductEntity

fun ProductResponseServer.toProductDomainList(): List<ProductEntity> = results.map { productServer ->
    productServer.run {
        ProductEntity(
            id,
            title,
            price,
            image,
            attributes?.map { it.toAttributesDomain() }
        )
    }
}

fun AttributesServer.toAttributesDomain() = AttributesEntity(
    id,
    valueId,
    name,
    valueName,
    attributeGroupId,
    attributeGroupName
)
