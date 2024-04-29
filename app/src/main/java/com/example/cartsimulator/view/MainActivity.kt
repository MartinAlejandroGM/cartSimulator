package com.example.cartsimulator.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cartsimulator.adapter.ItemTouchAdapter
import com.example.cartsimulator.adapter.ProductsRecyclerView
import com.example.cartsimulator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var cartListAdapter: ProductsRecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.pokeListRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            cartListAdapter = ProductsRecyclerView()
            adapter = cartListAdapter
            ItemTouchHelper(ItemTouchAdapter(cartListAdapter)).attachToRecyclerView(this)
        }
    }
}