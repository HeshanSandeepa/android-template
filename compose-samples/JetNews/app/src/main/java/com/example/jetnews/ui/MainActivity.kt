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

package com.example.jetnews.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.lifecycle.ViewModelProvider
import com.example.jetnews.JetNewsApplication
import com.example.jetnews.data.AppContainerImpl
import com.example.jetnews.ui.home.HomeViewModel
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {

      //  (application as JetNewsApplication).appComponent.inject(this)


        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        setContent {
            val widthSizeClass = calculateWindowSizeClass(this).widthSizeClass
            JetNewsApp(homeViewModel, widthSizeClass)
        }
    }
}
