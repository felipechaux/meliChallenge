package com.meli.android.meliproductapp.requestmanager

import com.meli.android.meliproductapp.requestmanager.ApiConstants.SEARCH_PRODUCT
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET(SEARCH_PRODUCT)
    fun getProductsByQuery(
        @Query("q") query: String
    ): Single<ProductResponseServer>
}
