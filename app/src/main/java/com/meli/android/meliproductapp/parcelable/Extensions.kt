package com.meli.android.meliproductapp.parcelable

import com.meli.android.meliproductapp.domain.AttributesEntity
import com.meli.android.meliproductapp.domain.ProductEntity

// Mappers
fun ProductEntity.toProductParcelable() = attributes?.map { it.toAttributesParcelable() }?.let {
    ProductParcelable(
        id,
        title,
        price,
        image,
        it
    )
}

fun ProductParcelable.toProductDomain() = ProductEntity(
    id,
    title,
    price,
    image,
    attributes.map { it.toAttributesDomain() }
)

fun AttributesEntity.toAttributesParcelable() = AttributesParcelable(
    id,
    valueId,
    name,
    valueName,
    attributeGroupId,
    attributeGroupName
)

fun AttributesParcelable.toAttributesDomain() = AttributesEntity(
    id,
    valueId,
    name,
    valueName,
    attributeGroupId,
    attributeGroupName
)

