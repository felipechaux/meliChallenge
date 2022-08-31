package com.meli.android.meliproductapp.requestmanager.di

import com.meli.android.meliproductapp.data.RemoteProductDataSource
import com.meli.android.meliproductapp.requestmanager.ApiConstants
import com.meli.android.meliproductapp.requestmanager.ProductRequest
import com.meli.android.meliproductapp.requestmanager.ProductRetrofitDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class APIModule {

    @Provides
    fun productRequestProvider(
        @Named("baseUrl") baseUrl: String
    ) = ProductRequest(baseUrl)

    @Provides
    @Singleton
    @Named("baseUrl")
    fun baseUrlProvider(): String = ApiConstants.BASE_API_URL

    @Provides
    fun remoteProductDataSourceProvider(
        productRequest: ProductRequest
    ): RemoteProductDataSource = ProductRetrofitDataSource(productRequest)
}
