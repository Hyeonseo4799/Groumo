package com.ragdoll.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ragdoll.designsystem.theme.KakaoContainer
import com.ragdoll.designsystem.theme.KakaoLabel

@Composable
fun KakaoLoginButton(
    modifier: Modifier = Modifier,
    kakaoLogin: () -> Unit
) {
    Button(
        onClick = { kakaoLogin() },
        colors = ButtonDefaults.buttonColors(containerColor = KakaoContainer),
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
        shape = RoundedCornerShape(20.dp),
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_kakao),
                contentDescription = null
            )
            Text(
                text = stringResource(R.string.kakao_login),
                color = KakaoLabel,
                modifier = Modifier.padding(5.dp),
                fontSize = 16.sp,

            )
        }
    }
}