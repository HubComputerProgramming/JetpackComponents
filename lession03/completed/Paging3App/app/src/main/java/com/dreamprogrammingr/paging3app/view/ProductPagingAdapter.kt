package com.dreamprogrammingr.paging3app.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dreamprogrammingr.paging3app.R
import com.dreamprogrammingr.paging3app.model.ProductBean
import kotlinx.android.synthetic.main.product_item.view.*

class ProductPagingAdapter : PagingDataAdapter<ProductBean, ProductPagingAdapter.ProductViewHolder>(DIFF_CALLBACK) {
    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(product:ProductBean){
            itemView.tvProductName.text = product.productName
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ProductBean>(){

            override fun areItemsTheSame(oldItem: ProductBean, newItem: ProductBean): Boolean = oldItem._id == newItem._id

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: ProductBean, newItem: ProductBean): Boolean {
               return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item,
            parent,
            false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }



}
