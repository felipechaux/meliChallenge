package com.meli.android.meliproductapp.di

import android.app.Application
import com.meli.android.meliproductapp.data.RepositoryModule
import com.meli.android.meliproductapp.requestmanager.di.APIModule
import com.meli.android.meliproductapp.usecases.UseCaseModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [APIModule::class, RepositoryModule::class, UseCaseModule::class])
interface MeliProductAppComponent {

    fun inject(module: ProductListModule): ProductListComponent

    @Component.Factory
    interface MeliProduct {
        fun create(@BindsInstance app: Application): MeliProductAppComponent
    }
}
