package com.example.harajtask.car_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.RequestManager
import com.example.harajtask.R
import com.example.harajtask.databinding.FragmentCarListBinding
import com.example.harajtask.util.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CarListFragment : Fragment(R.layout.fragment_car_list) {
private lateinit var binding:FragmentCarListBinding
      private val viewModel: CarListViewModel by viewModels()
    @Inject
    lateinit var requestManager: RequestManager
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentCarListBinding.bind(view)
        subScribeToObservers()
    }

    private fun subScribeToObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            launch {
                viewModel.getCarList.collect {
                    when (it.status) {
                        Status.LOADING -> {

                        }
                        Status.SUCCESS -> {
                            initRecyclerView(it.data)

                        }
                    }
                }
            }
        }
    }

    private fun initRecyclerView(data: List<CarEntity>?) {
        val carAdapter=CarAdapter(requestManager){
            onCarClicked(it)
        }
        carAdapter.submitList(data)
        binding.recyclerView.apply {
            adapter=carAdapter
            layoutManager=LinearLayoutManager(activity)
        }
    }

    private fun onCarClicked(carEntity: CarEntity) {
       findNavController().navigate(CarListFragmentDirections.actionCarListFragmentToCarDetailFragment(carEntity))
    }
}