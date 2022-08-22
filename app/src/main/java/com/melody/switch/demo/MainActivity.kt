package com.melody.switch.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var checkedButton by remember {
                mutableStateOf(false)
            }
            Box(modifier = Modifier.fillMaxSize()) {
                /*IOSSwitchButton(
                    modifier = Modifier.align(Alignment.Center),
                    checked = checkedButton,
                    onCheckedChange = {
                        checkedButton = it
                    }
                )*/
                IosSwitchButton(
                    modifier = Modifier.align(Alignment.Center),
                    checked = checkedButton,
                    onCheckedChange = {
                        checkedButton = it
                    }
                )
            }
        }
    }
}
