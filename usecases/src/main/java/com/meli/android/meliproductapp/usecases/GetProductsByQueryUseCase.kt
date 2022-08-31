package com.meli.android.meliproductapp.usecases

import com.meli.android.meliproductapp.data.ProductRepository
import com.meli.android.meliproductapp.domain.ProductEntity
import io.reactivex.Single

class GetProductsByQueryUseCase(private val productRepository: ProductRepository) {

    fun invoke(query: String): Single<List<ProductEntity>> =
        productRepository.getProductsByQuery(query)
}
