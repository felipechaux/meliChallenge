package com.meli.android.meliproductapp.usecases

import com.meli.android.meliproductapp.data.ProductRepository
import com.meli.android.meliproductapp.domain.ProductEntity
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.given
import io.reactivex.Single
import org.junit.Before
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
class GetProductsByQueryUseCaseTest {

    @Mock
    private lateinit var productRepository: ProductRepository

    private lateinit var getProductsByQueryUseCase: GetProductsByQueryUseCase

    @Before
    fun setup() {
        getProductsByQueryUseCase = GetProductsByQueryUseCase(productRepository)
    }

    @Test
    fun `get product by query useCase should return an expected list of products given a query`() {
        val expectedResult = listOf(mockedProduct.copy(id = "1"))
        given(productRepository.getProductsByQuery(any())).willReturn(
            Single.just(
                expectedResult
            )
        )

        getProductsByQueryUseCase.invoke("abc")
            .test()
            .assertComplete()
            .assertNoErrors()
            .assertValueCount(1)
            .assertValue(expectedResult)
    }
}

val mockedProduct = ProductEntity(
    "",
    "",
    0.0,
    "",
    listOf()
)
