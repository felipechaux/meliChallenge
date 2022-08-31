package com.meli.android.meliproductapp.parcelable

import com.meli.android.meliproductapp.domain.ProductEntity

fun ProductEntity.toProductParcelable() = ProductParcelable(
    id,
    title,
    price,
    image
)

fun ProductParcelable.toProductDomain() = ProductEntity(
    id,
    title,
    price,
    image
)
