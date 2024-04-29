package com.example.cartsimulator.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.cartsimulator.Interface.ItemTouchHelperAdapter
import com.example.cartsimulator.R
import com.example.cartsimulator.databinding.CartListLayoutBinding
import com.example.cartsimulator.extension.initProducts
import com.example.cartsimulator.models.Product

class ProductsRecyclerView : RecyclerView.Adapter<ProductsRecyclerView.CartListViewHolder>(), ItemTouchHelperAdapter {
    private var cartItems = ArrayList<Product>()

    init {
        initCartList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartListViewHolder =
        CartListViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_list_layout, parent, false))

    override fun getItemCount(): Int = cartItems.size

    override fun onBindViewHolder(holder: CartListViewHolder, position: Int) {
        holder.cartListBinding(cartItems[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initCartList(){
        cartItems = initProducts()
        notifyDataSetChanged()
    }

    inner class CartListViewHolder constructor(v: View) : RecyclerView.ViewHolder(v){
        private val binding = CartListLayoutBinding.bind(v)

        fun cartListBinding(cartList: Product) = with(binding) {
            binding.name.text = cartList.name
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onItemSwiped(position: Int) {
        cartItems.removeAt(position)
        notifyDataSetChanged()
    }
}