package com.example.jetnews.di

import com.example.jetnews.JetNewsApplication
import com.example.jetnews.ui.MainActivity
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

// Definition of a Dagger component
@Singleton
@Component(modules = [AndroidInjectionModule::class,  RepoModule::class,  ViewModelModule::class])
interface AppComponent {

//    // Factory to create instances of the AppComponent
//    @Component.Factory
//    interface Factory {
//        // With @BindsInstance, the Context passed in will be available in the graph
//        fun create(@BindsInstance context: Context): AppComponent
//    }
//
    //fun inject(activity: MainActivity)

    fun inject(application: JetNewsApplication)
}