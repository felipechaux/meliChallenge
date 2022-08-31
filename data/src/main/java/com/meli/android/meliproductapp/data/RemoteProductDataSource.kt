package com.meli.android.meliproductapp.data

import com.meli.android.meliproductapp.domain.ProductEntity
import io.reactivex.Single

interface RemoteProductDataSource {
    fun getProductsByQuery(query: String): Single<List<ProductEntity>>
}
