package com.meli.android.meliproductapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.meli.android.meliproductapp.R
import com.meli.android.meliproductapp.databinding.FragmentProductDetailBinding
import com.meli.android.meliproductapp.domain.ProductEntity
import com.meli.android.meliproductapp.imagemanager.bindImageUrl
import com.meli.android.meliproductapp.parcelable.ProductParcelable
import com.meli.android.meliproductapp.parcelable.toProductDomain
import com.meli.android.meliproductapp.utils.Constants
import com.meli.android.meliproductapp.utils.setCurrencyFormat

class ProductDetailFragment : Fragment() {

    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        val view = binding?.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val productDetail: ProductParcelable =
            requireArguments().getParcelable(Constants.EXTRA_PRODUCT_DETAIL)!!
        loadProductDetail(productDetail.toProductDomain())
    }

    private fun loadProductDetail(productEntity: ProductEntity) {
        Log.d("${Log.INFO}", "detail: ${productEntity.title})")
        binding?.imageDetail?.bindImageUrl(
            url = productEntity.image,
            placeholder = R.drawable.ic_camera_alt_black,
            errorPlaceholder = R.drawable.ic_broken_image_black
        )
        binding?.titleDetail?.text = productEntity.title
        binding?.priceDetail?.text = productEntity.price?.let { setCurrencyFormat(it) }
    }
}
