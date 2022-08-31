package com.meli.android.meliproductapp.parcelable

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductParcelable(
    val id: String,
    val title: String,
    val price: Long?,
    val image: String
) : Parcelable
