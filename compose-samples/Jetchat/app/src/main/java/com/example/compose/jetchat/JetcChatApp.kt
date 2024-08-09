/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.compose.jetchat

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


enum class JetChatScreen(@StringRes val title: Int) {
    Conversation(title = R.string.app_name),
    Profile(title = R.string.choose_flavor),
}


@Composable
fun JetChatApp(
    //viewModel: OrderViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {




    Scaffold(
    ) { innerPadding ->
        //val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = JetChatScreen.Conversation.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = JetChatScreen.Conversation.name) {
//                StartOrderScreen(
//                    quantityOptions = DataSource.quantityOptions,
//                    onNextButtonClicked = {
//                        viewModel.setQuantity(it)
//                        navController.navigate(JetChatScreen.Profile.name)
//                    },
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(dimensionResource(R.dimen.padding_medium))
//                )
            }
            composable(route = JetChatScreen.Profile.name) {
                val context = LocalContext.current
//                SelectOptionScreen(
//                    subtotal = uiState.price,
//                    onNextButtonClicked = { navController.navigate(JetChatScreen.Pickup.name) },
//                    onCancelButtonClicked = {
//                        cancelOrderAndNavigateToStart(viewModel, navController)
//                    },
//                    options = DataSource.flavors.map { id -> context.resources.getString(id) },
//                    onSelectionChanged = { viewModel.setFlavor(it) },
//                    modifier = Modifier.fillMaxHeight()
//                )
            }
        }
    }
}
