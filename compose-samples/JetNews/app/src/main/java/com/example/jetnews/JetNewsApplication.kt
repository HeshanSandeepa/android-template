/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.jetnews

import android.app.Application
import com.example.jetnews.di.DaggerAppComponent
import javax.inject.Inject


class JetNewsApplication : Application(), HasAndroidInjector {
    companion object {
        const val JET_NEWS_APP_URI = "https://developer.android.com/jetnews"
    }

//    val appComponent: AppComponent by lazy {
//        // Creates an instance of AppComponent using its Factory constructor
//        // We pass the applicationContext that will be used as Context in the graph
//        DaggerAppComponent.factory().create(applicationContext)
//    }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)
    }
    override fun androidInjector(): AndroidInjector<Any> = androidInjector

}
