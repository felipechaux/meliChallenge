package com.meli.android.meliproductapp.domain

data class ProductEntity(
    val id: String,
    val title: String,
    val price: Double,
    val image: String,
    val attributes: List<AttributesEntity>?
)

data class AttributesEntity(
    val id: String,
    val valueId: String?,
    val name: String,
    val valueName: String?,
    val attributeGroupId: String,
    val attributeGroupName: String
)
