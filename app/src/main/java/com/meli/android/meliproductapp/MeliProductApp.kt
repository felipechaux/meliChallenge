package com.meli.android.meliproductapp

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.meli.android.meliproductapp.di.DaggerMeliProductAppComponent
import com.meli.android.meliproductapp.di.MeliProductAppComponent

class MeliProductApp : Application() {

    //region Override Methods & Callbacks

    lateinit var component: MeliProductAppComponent

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        component = initAppComponent()
    }

    private fun initAppComponent() = DaggerMeliProductAppComponent.factory().create(this)
}
