package com.imadev.laundryapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imadev.laundryapp.R
import com.imadev.laundryapp.databinding.CategoryItemRowBinding
import com.imadev.laundryapp.remote.data.CategoriesResponse
import com.imadev.laundryapp.remote.data.Category

class CategoryAdapter(private val categories: CategoriesResponse?) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {


    private var onClick: ((Category, Int) -> Unit)? = null


    class ViewHolder(private val binding: CategoryItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val context: Context = binding.root.context

        fun bind(category: Category) {
            with(binding) {
                categoryName.text = category.label
                categoryImage.setImageResource(R.drawable.ic_t_shirt)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CategoryItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories?.data?.get(position) ?: return
        holder.bind(category)
        holder.itemView.setOnClickListener {
            onClick?.let { it1 -> it1(category, position) }
        }
    }

    override fun getItemCount(): Int = categories?.data?.size ?: 0

    fun setItemClickListener(onClick: (Category, Int) -> Unit) {
        this.onClick = onClick
    }


}