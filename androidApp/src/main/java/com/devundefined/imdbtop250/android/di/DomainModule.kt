package com.devundefined.imdbtop250.android.di

import com.devundefined.imdbtop250.domain.Movie250TopRepository
import com.devundefined.imdbtop250.sharedFeature.di.FeatureComponent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {
    @Provides
    fun provideRepository(): Movie250TopRepository = FeatureComponent.provideTop250Repository()
}
