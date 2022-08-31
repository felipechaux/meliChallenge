package com.meli.android.meliproductapp.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meli.android.meliproductapp.R
import com.meli.android.meliproductapp.databinding.ItemProductResultBinding
import com.meli.android.meliproductapp.domain.ProductEntity
import com.meli.android.meliproductapp.imagemanager.bindImageUrl
import com.meli.android.meliproductapp.utils.bindingInflate
import com.meli.android.meliproductapp.utils.setCurrencyFormat
import kotlinx.android.synthetic.main.item_product_result.view.product_image

class ProductResultAdapter(
    private val productList: List<ProductEntity>,
    private val listener: (ProductEntity) -> Unit
) :
    RecyclerView.Adapter<ProductResultAdapter.ProductResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProductResultViewHolder(
        parent.bindingInflate(R.layout.item_product_result, false),
        listener
    )

    override fun onBindViewHolder(holder: ProductResultViewHolder, position: Int) {
        holder.bind(productList.get(position))
    }

    override fun getItemCount() = productList.size

    override fun getItemId(position: Int): Long = productList[position].id.toLong()

    class ProductResultViewHolder(
        private val dataBinding: ItemProductResultBinding,
        private val listener: (ProductEntity) -> Unit
    ) : RecyclerView.ViewHolder(dataBinding.root) {

        fun bind(item: ProductEntity) {
            dataBinding.product = item
            dataBinding.currencyPrice = item.price?.let { setCurrencyFormat(it) }
            itemView.product_image.bindImageUrl(
                url = item.image,
                placeholder = R.drawable.ic_camera_alt_black,
                errorPlaceholder = R.drawable.ic_broken_image_black
            )
            itemView.setOnClickListener {
                listener(item)
            }
        }
    }
}
