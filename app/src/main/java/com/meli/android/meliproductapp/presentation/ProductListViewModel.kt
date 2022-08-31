package com.meli.android.meliproductapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.meli.android.meliproductapp.domain.ProductEntity
import com.meli.android.meliproductapp.usecases.GetProductsByQueryUseCase
import io.reactivex.disposables.CompositeDisposable

class ProductListViewModel(private val getProductsByQueryUseCase: GetProductsByQueryUseCase) :
    ViewModel() {
    private val disposable = CompositeDisposable()

    private val _events = MutableLiveData<Event<ProductListNavigation>>()
    val events: LiveData<Event<ProductListNavigation>> get() = _events

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    fun getProductsByQuery(query: String) {
        disposable.add(
            getProductsByQueryUseCase.invoke(query).doOnSubscribe {
                _events.value = Event(ProductListNavigation.ShowLoading)
            }
                .subscribe({ characterList ->
                    if (characterList.isEmpty()) {
                        _events.value = Event(ProductListNavigation.HideLoading)
                        _events.value = Event(ProductListNavigation.ShowEmptyListMessage)
                        return@subscribe
                    }
                    _events.value = Event(ProductListNavigation.HideLoading)
                    _events.value =
                        Event(ProductListNavigation.ShowProductListResult(characterList))
                }, { error ->
                    _events.value = Event(ProductListNavigation.HideLoading)
                    _events.value = Event(ProductListNavigation.ShowProductListError(error))
                })
        )
    }

    sealed class ProductListNavigation {
        data class ShowProductListError(val error: Throwable) : ProductListNavigation()
        data class ShowProductListResult(val productList: List<ProductEntity>) :
            ProductListNavigation()

        object HideLoading : ProductListNavigation()
        object ShowLoading : ProductListNavigation()
        object ShowEmptyListMessage : ProductListNavigation()
    }
}
