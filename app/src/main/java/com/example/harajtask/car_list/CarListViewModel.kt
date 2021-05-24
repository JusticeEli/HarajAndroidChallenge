package com.example.harajtask.car_list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel

class CarListViewModel @ViewModelInject constructor(private val repository: MainRepository):ViewModel() {

    val getCarList=repository.getCarList()
}