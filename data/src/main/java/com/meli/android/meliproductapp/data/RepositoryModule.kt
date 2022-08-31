package com.meli.android.meliproductapp.data

import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun productRepositoryProvider(
        remoteProductDataSource: RemoteProductDataSource
    ) = ProductRepository(remoteProductDataSource)
}
