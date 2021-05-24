package com.example.harajtask.car_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.RequestManager
import com.example.harajtask.R
import com.example.harajtask.databinding.FragmentCarDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CarDetailFragment: Fragment(R.layout.fragment_car_detail) {
private lateinit var binding:FragmentCarDetailBinding
private val navArgs:CarDetailFragmentArgs by navArgs()
    @Inject
    lateinit var requestManager: RequestManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentCarDetailBinding.bind(view)
        setData()
    }

    private fun setData() {
        val carEntity=navArgs.carEntity
        binding.apply {
            requestManager.load(carEntity.thumbURL).into(ivImage)
            tvTitle.text=carEntity.title
            tvDate.text=carEntity.date.toString()
            tvUsername.text=carEntity.username
            tvCity.text=carEntity.city
            tvDescription.text=carEntity.body
            tvContacts.text="Please contact me\n +9738783638738737"
        }
    }
}