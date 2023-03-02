package com.ragdoll.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ragdoll.designsystem.component.Loading
import com.ragdoll.designsystem.theme.lineSeed
import com.ragdoll.designsystem.component.Error


@Composable
fun LoginRoute(
    navigateToGroup: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val loginState by viewModel.uiState.collectAsStateWithLifecycle()

    LoginScreen(
        modifier = modifier,
        uiState = loginState,
        navigateToGroup = navigateToGroup,
        kakaoLogin = viewModel::loginWithKakaoAccount
    )
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    uiState: UserUiState,
    navigateToGroup: (Int) -> Unit,
    kakaoLogin: () -> Unit
) {
    when (uiState) {
        is UserUiState.Success -> navigateToGroup(uiState.user.id)
        is UserUiState.Error -> Error(uiState.message)
        UserUiState.Loading -> Loading()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .systemBarsPadding()
    ) {
        Spacer(modifier = modifier.weight(1f))
        Image(
            painter = painterResource(R.drawable.ic_logo),
            contentDescription = null
        )
        Spacer(modifier = modifier.height(12.dp))
        Text(
            text = stringResource(R.string.app_name_lowercase),
            fontSize = 24.sp,
            fontFamily = lineSeed
        )
        Spacer(modifier = modifier.weight(1f))
        KakaoLoginButton(modifier = Modifier.fillMaxWidth()) {
            kakaoLogin()
        }
        Spacer(modifier = modifier.weight(1f))
    }

}