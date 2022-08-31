package com.meli.android.meliproductapp.requestmanager

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.meli.android.meliproductapp.requestmanager.ApiConstants.KEY_ATTRIBUTES
import com.meli.android.meliproductapp.requestmanager.ApiConstants.KEY_ATTRIBUTE_GROUP_ID
import com.meli.android.meliproductapp.requestmanager.ApiConstants.KEY_ATTRIBUTE_GROUP_NAME
import com.meli.android.meliproductapp.requestmanager.ApiConstants.KEY_ID
import com.meli.android.meliproductapp.requestmanager.ApiConstants.KEY_IMAGE
import com.meli.android.meliproductapp.requestmanager.ApiConstants.KEY_NAME
import com.meli.android.meliproductapp.requestmanager.ApiConstants.KEY_PRICE
import com.meli.android.meliproductapp.requestmanager.ApiConstants.KEY_RESULTS
import com.meli.android.meliproductapp.requestmanager.ApiConstants.KEY_TITLE
import com.meli.android.meliproductapp.requestmanager.ApiConstants.KEY_VALUE_ID
import com.meli.android.meliproductapp.requestmanager.ApiConstants.KEY_VALUE_NAME
import kotlinx.android.parcel.Parcelize

data class ProductResponseServer(
    @SerializedName(KEY_RESULTS) val results: List<ProductServer>
)

@Parcelize
data class ProductServer(
    @SerializedName(KEY_ID) val id: String,
    @SerializedName(KEY_TITLE) val title: String,
    @SerializedName(KEY_PRICE) val price: Double,
    @SerializedName(KEY_IMAGE) val image: String,
    @SerializedName(KEY_ATTRIBUTES) val attributes: List<AttributesServer>?
) : Parcelable

@Parcelize
data class AttributesServer(
    @SerializedName(KEY_ID) val id: String,
    @SerializedName(KEY_VALUE_ID) val valueId: String?,
    @SerializedName(KEY_NAME) val name: String,
    @SerializedName(KEY_VALUE_NAME) val valueName: String?,
    @SerializedName(KEY_ATTRIBUTE_GROUP_ID) val attributeGroupId: String,
    @SerializedName(KEY_ATTRIBUTE_GROUP_NAME) val attributeGroupName: String
) : Parcelable
