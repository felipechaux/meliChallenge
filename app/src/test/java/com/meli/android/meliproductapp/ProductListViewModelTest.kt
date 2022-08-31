package com.meli.android.meliproductapp

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.meli.android.meliproductapp.domain.ProductEntity
import com.meli.android.meliproductapp.presentation.Event
import com.meli.android.meliproductapp.presentation.ProductListViewModel
import com.meli.android.meliproductapp.usecases.GetProductsByQueryUseCase
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class ProductListViewModelTest {

    @get: Rule
    val rxSchedulerRule = RxSchedulerRule()

    @get: Rule
    val rule = InstantTaskExecutorRule()

    // verificacion de eventos
    @Mock
    lateinit var getProductsByQueryUseCase: GetProductsByQueryUseCase

    @Mock
    lateinit var eventObserver: Observer<Event<ProductListViewModel.ProductListNavigation>>

    private lateinit var productListViewModel: ProductListViewModel

    @Before
    fun setUp() {
        productListViewModel = ProductListViewModel(getProductsByQueryUseCase)
    }

    @Test
    fun `getProductsByQuery should return an expected success list of products`() {
        val expectedResult = listOf(mockedProduct.copy(id = "1"))

        given(getProductsByQueryUseCase.invoke(any())).willReturn(Single.just(expectedResult))

        productListViewModel.events.observeForever(eventObserver)

        productListViewModel.getProductsByQuery("auto")

        verify(eventObserver).onChanged(
            Event(
                ProductListViewModel.ProductListNavigation.ShowProductListResult(
                    expectedResult
                )
            )
        )
    }
}

val mockedProduct = ProductEntity(
    "",
    "",
    0.0,
    "",
    listOf()
)
