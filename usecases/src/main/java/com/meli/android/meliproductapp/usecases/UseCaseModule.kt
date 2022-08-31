package com.meli.android.meliproductapp.usecases

import com.meli.android.meliproductapp.data.ProductRepository
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun getProductsByQueryUseCaseProvider(productRepository: ProductRepository) =
        com.meli.android.meliproductapp.usecases.GetProductsByQueryUseCase(productRepository)
}
