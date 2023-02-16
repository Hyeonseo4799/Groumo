package com.ragdoll.login

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel = hiltViewModel()) {
    Button(onClick = { viewModel.kakaoLogin() }) {
        Text(stringResource(R.string.kakao_login))
    }
}