package com.example.jetnews.di


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetnews.ui.home.HomeViewModel
import com.example.jetnews.ui.interests.InterestsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


// Tells Dagger this is a Dagger module
//@Module
//abstract class ViewModelModule {
//    @Binds
//    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(HomeViewModel::class)
//    abstract fun bindsHomeViewModel(viewModel: HomeViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(InterestsViewModel::class)
//    abstract fun bindsInterestsViewModel(viewModel: InterestsViewModel): ViewModel
//}

