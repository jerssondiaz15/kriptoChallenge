package com.jersson.diaz.kriptochallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jersson.diaz.kriptochallenge.navigation.NavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                NavHost(
                    goBack = { onBackPressedDispatcher.onBackPressed() }
                )
            }
        }
    }
}