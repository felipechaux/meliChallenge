package com.meli.android.meliproductapp.data

class ProductRepository(private val remoteProductDataSource: RemoteProductDataSource) {
    fun getProductsByQuery(query: String) = remoteProductDataSource.getProductsByQuery(query)
}
