package com.meli.android.meliproductapp.parcelable

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductParcelable(
    val id: String,
    val title: String,
    val price: Double,
    val image: String,
    val attributes: List<AttributesParcelable>
) : Parcelable

@Parcelize
data class AttributesParcelable(
    val id: String,
    val valueId: String?,
    val name: String,
    val valueName: String?,
    val attributeGroupId: String,
    val attributeGroupName: String
) : Parcelable
