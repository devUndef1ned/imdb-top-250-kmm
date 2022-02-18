package com.devundefined.imdbtop250.android.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object NetworkModule {
    /*@Provides
    fun provideApiClient(): ApiClient = ApiClient()

    @Provides
    fun provideNetworkDataSource(apiClient: ApiClient): NetworkDataSource =
        NetworkDataSource(apiClient)*/
}