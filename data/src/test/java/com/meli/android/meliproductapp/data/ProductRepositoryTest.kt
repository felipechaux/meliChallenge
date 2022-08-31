import com.meli.android.meliproductapp.data.ProductRepository
import com.meli.android.meliproductapp.data.RemoteProductDataSource
import com.meli.android.meliproductapp.domain.ProductEntity
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.given
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ProductRepositoryTest {

    @Mock
    private lateinit var remoteProductDataSource: RemoteProductDataSource

    private lateinit var productRepository: ProductRepository

    @Before
    fun setUp() {
        productRepository = ProductRepository(remoteProductDataSource)
    }

    @Test
    fun `getProductsByQuery should return an expected list of products given a query`() {
        val expectedResult = listOf(mockedProduct.copy(id = "1"))
        given(remoteProductDataSource.getProductsByQuery(any())).willReturn(
            Single.just(
                expectedResult
            )
        )

        // execute test
        productRepository.getProductsByQuery("123")
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
    0,
    ""
)
