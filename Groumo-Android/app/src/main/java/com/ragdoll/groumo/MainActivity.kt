package com.ragdoll.groumo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.ragdoll.groumo.navigation.GroumoNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            GroumoNavHost(navController = rememberNavController())
        }
    }
}