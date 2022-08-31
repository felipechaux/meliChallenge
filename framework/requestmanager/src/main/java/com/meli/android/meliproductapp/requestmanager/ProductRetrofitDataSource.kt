package com.meli.android.meliproductapp.requestmanager

import com.meli.android.meliproductapp.data.RemoteProductDataSource
import com.meli.android.meliproductapp.domain.ProductEntity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ProductRetrofitDataSource(private val productRequest: ProductRequest) :
    RemoteProductDataSource {
    override fun getProductsByQuery(query: String): Single<List<ProductEntity>> {
        return productRequest.getService<ProductService>().getProductsByQuery(query)
            .map(ProductResponseServer::toProductDomainList)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}
