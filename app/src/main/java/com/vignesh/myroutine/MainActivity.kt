package com.vignesh.myroutine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.vignesh.myroutine.ui.MyRoutineApp
import com.vignesh.myroutine.ui.theme.MyRoutineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyRoutineTheme {
                MyRoutineApp()
            }
        }
    }
}
