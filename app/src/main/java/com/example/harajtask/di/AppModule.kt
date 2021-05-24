package com.example.harajtask.di

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.harajtask.car_list.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRepository(
        @ApplicationContext context:Context
    ):MainRepository{
        return MainRepository(context)
    }
    @Provides
    @Singleton
    fun providesRequestManager(
        @ApplicationContext context:Context
    ): RequestManager {
        return Glide.with(context)
    }


}