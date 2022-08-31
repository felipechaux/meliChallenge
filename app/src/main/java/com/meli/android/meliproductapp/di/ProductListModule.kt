package com.meli.android.meliproductapp.di

import com.meli.android.meliproductapp.usecases.GetProductsByQueryUseCase
import com.meli.android.meliproductapp.presentation.ProductListViewModel
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@Module
class ProductListModule {

    @Provides
    fun productListViewModelProvider(getProductsByQueryUseCase: com.meli.android.meliproductapp.usecases.GetProductsByQueryUseCase) =
        ProductListViewModel(getProductsByQueryUseCase)
}

@Subcomponent(modules = [(ProductListModule::class)])
interface ProductListComponent {
    val productListViewModel: ProductListViewModel
}
