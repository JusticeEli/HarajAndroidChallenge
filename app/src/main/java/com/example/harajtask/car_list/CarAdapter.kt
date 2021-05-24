package com.example.harajtask.car_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.harajtask.R
import com.example.harajtask.databinding.CarItemBinding


class CarAdapter(
    private val requestManager: RequestManager,
    private val onClick: (CarEntity) -> Unit
) :
    ListAdapter<CarEntity, CarAdapter.CarViewHolder>(
        DIFF_UTIL
    ) {

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<CarEntity>() {
            override fun areItemsTheSame(oldItem: CarEntity, newItem: CarEntity): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: CarEntity, newItem: CarEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class CarViewHolder(val binding: CarItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CarEntity): Unit {
            binding.root.setOnClickListener {
                onClick(item)
            }

            requestManager.load(item.thumbURL).into(binding.ivImage)
            binding.tvTitle.text = item.title
            binding.tvDate.text = item.date.toString()
            binding.tvUsername.text = item.username
            binding.tvCity.text = item.city


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_item, parent,false)
        val binding = CarItemBinding.bind(view)
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}