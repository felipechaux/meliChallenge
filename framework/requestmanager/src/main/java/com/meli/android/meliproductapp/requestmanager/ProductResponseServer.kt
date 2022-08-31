package com.meli.android.meliproductapp.requestmanager

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.meli.android.meliproductapp.requestmanager.ApiConstants.KEY_ID
import com.meli.android.meliproductapp.requestmanager.ApiConstants.KEY_PRICE
import com.meli.android.meliproductapp.requestmanager.ApiConstants.KEY_RESULTS
import com.meli.android.meliproductapp.requestmanager.ApiConstants.KEY_TITLE
import kotlinx.android.parcel.Parcelize

data class ProductResponseServer(
    @SerializedName(KEY_RESULTS) val results: List<ProductServer>
)

@Parcelize
data class ProductServer(
    @SerializedName(KEY_ID) val id: String,
    @SerializedName(KEY_TITLE) val title: String,
    @SerializedName(KEY_PRICE) val price: Long
) : Parcelable
