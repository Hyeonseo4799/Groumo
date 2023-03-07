package com.ragdoll.groumo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.ragdoll.designsystem.theme.GroumoTheme
import com.ragdoll.groumo.navigation.GroumoNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroumoTheme {
                Surface(modifier = Modifier.fillMaxSize()) {

                    GroumoNavHost(navController = rememberAnimatedNavController())
                }
            }
        }
    }
}