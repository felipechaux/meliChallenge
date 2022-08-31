package com.meli.android.meliproductapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.meli.android.meliproductapp.adapters.ProductResultAdapter
import com.meli.android.meliproductapp.databinding.FragmentProductListBinding
import com.meli.android.meliproductapp.di.ProductListComponent
import com.meli.android.meliproductapp.di.ProductListModule
import com.meli.android.meliproductapp.domain.ProductEntity
import com.meli.android.meliproductapp.presentation.ProductListViewModel
import com.meli.android.meliproductapp.utils.Constants
import com.meli.android.meliproductapp.utils.app
import com.meli.android.meliproductapp.utils.getViewModel
import com.meli.android.meliproductapp.utils.showLongToast

class ProductListFragment : Fragment() {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding

    private lateinit var productResultAdapter: ProductResultAdapter
    private lateinit var productListComponent: ProductListComponent

    private val productListViewModel by lazy {
        getViewModel { productListComponent.productListViewModel }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        val view = binding?.root
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        productListComponent = requireContext().app.component.inject(ProductListModule())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val query = requireArguments().getString(Constants.EXTRA_QUERY)
        println("el query es $query")
        initObservers()
        query?.let {
            productListViewModel.getProductsByQuery(it)
        } ?: context?.showLongToast("No data")
    }

    private fun initObservers() {
        productListViewModel.events.observe(
            viewLifecycleOwner,
            Observer { events ->
                events?.getContentIfNotHandled()?.let { navigation ->
                    when (navigation) {
                        ProductListViewModel.ProductListNavigation.ShowLoading -> {
                            binding?.progressProduct?.isVisible = true
                        }
                        ProductListViewModel.ProductListNavigation.HideLoading -> {
                            binding?.progressProduct?.isVisible = false
                        }
                        is ProductListViewModel.ProductListNavigation.ShowProductListResult -> navigation.run {
                            Log.d("${Log.INFO}", "productlist: $productList\")")
                            loadProductResult(productList)
                        }
                        is ProductListViewModel.ProductListNavigation.ShowProductListError -> {
                            context?.showLongToast("Error")
                        }
                    }
                }
            }
        )
    }

    private fun loadProductResult(productList: List<ProductEntity>) {
        productResultAdapter =
            ProductResultAdapter(productList as ArrayList<ProductEntity>)

        binding?.rvProductList?.run {
            adapter = productResultAdapter
        }
    }
}