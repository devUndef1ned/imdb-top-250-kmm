package com.devundefined.imdbtop250.android.di

import com.devundefined.imdbtop250.domain.Movie250TopRepository
import com.devundefined.imdbtop250.domain.Movie250TopRepositoryImpl
import com.devundefined.imdbtop250.networking.ApiClient
import com.devundefined.imdbtop250.networking.NetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {
    @Provides
    fun provideRepository(networkDataSource: NetworkDataSource): Movie250TopRepository =
        Movie250TopRepositoryImpl(networkDataSource)

    @Provides
    fun provideApiClient(): ApiClient = ApiClient()

    @Provides
    fun provideNetworkDataSource(apiClient: ApiClient): NetworkDataSource =
        NetworkDataSource(apiClient)
}