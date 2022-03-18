package com.devundefined.imdbtop250.sharedFeature.di

import com.devundefined.imdbtop250.domain.Movie250TopRepository
import com.devundefined.imdbtop250.domain.Movie250TopRepositoryImpl
import com.devundefined.imdbtop250.networking.ApiClient
import com.devundefined.imdbtop250.networking.NetworkDataSource

object FeatureComponent {

    private fun provideApiClient(): ApiClient = ApiClient()

    private fun provideNetworkDataSource(): NetworkDataSource = NetworkDataSource(provideApiClient())

    fun provideTop250Repository(): Movie250TopRepository = Movie250TopRepositoryImpl(provideNetworkDataSource())
}
