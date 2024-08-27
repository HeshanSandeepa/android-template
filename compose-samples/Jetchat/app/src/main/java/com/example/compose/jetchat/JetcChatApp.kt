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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.jetchat.conversation.ConversationScreen
import com.example.compose.jetchat.data.exampleUiState
import com.example.compose.jetchat.profile.ProfileError
import com.example.compose.jetchat.profile.ProfileScreen
import com.example.compose.jetchat.profile.ProfileViewModel

enum class JetChatScreen(@StringRes val title: Int) {
    Conversation(title = R.string.app_name),
    Profile(title = R.string.choose_flavor),
}

@Composable
fun JetChatApp(
    viewModel: ProfileViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = JetChatScreen.Conversation.name,
            modifier = Modifier.padding(innerPadding)
        ) {

            //viewModel.setUserId()
            composable(route = JetChatScreen.Conversation.name) {
                ConversationScreen(uiState = exampleUiState , navigateToProfile = { user ->
                    navController.navigate(JetChatScreen.Profile.name)

                    // Click callback
//                    val bundle = bundleOf("userId" to user)
//                    navController.navigate(
//                        R.id.nav_profile,
//                        bundle
//                    )
                },)
                //userData?.let { it1 -> ProfileScreen(userData = it1) }
            }
            composable(route = JetChatScreen.Profile.name) {
                val userData by viewModel.userData.observeAsState()
                if (userData == null) {
                    ProfileError()
                } else {
                    ProfileScreen(userData = userData!!)
                }
            }
        }
    }
}
