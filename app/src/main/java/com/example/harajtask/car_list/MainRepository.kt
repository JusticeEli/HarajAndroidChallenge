package com.example.harajtask.car_list

import android.content.Context
import android.content.res.AssetManager
import android.util.Log
import com.example.harajtask.util.Resource
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.flow


class MainRepository(private val context: Context) {
    private  val TAG = "MainRepository"
    fun getCarList()= flow<Resource<List<CarEntity>>> {
        emit(Resource.loading("loading cars..."))
        val type = object : TypeToken<List<CarEntity>>() {}.type
        val gson = GsonBuilder().create()
        val carList = gson.fromJson<List<CarEntity>>(context.assets.readAssetsFile("data.json"), type)
        Log.d(TAG, "getCarList: $carList")
        emit(Resource.success(carList))
    }

    private fun AssetManager.readAssetsFile(fileName: String): String =
        open(fileName).bufferedReader().use { it.readText() }
}