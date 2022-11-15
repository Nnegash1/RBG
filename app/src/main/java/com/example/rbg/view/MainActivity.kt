package com.example.rbg.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chargemap.compose.numberpicker.NumberPicker
import com.example.rbg.view.ui.theme.RBGTheme
import com.example.rbg.viewmodel.RBGViewModel

class MainActivity : ComponentActivity() {
    private val vm: RBGViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val r = vm.colorR.collectAsState().value
            val b = vm.colorB.collectAsState().value
            val g = vm.colorG.collectAsState().value

            RBGTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MultiplayerBox(vm, r, b, g)
                }
            }
        }
    }
}

@Composable
fun MultiplayerBox(vm: RBGViewModel, r: Int, b: Int, g: Int, modifier: Modifier = Modifier) {
    val pickerValue = remember { mutableStateOf(0) }

    Box(
        modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Text(
            modifier = Modifier
                .padding(start = 20.dp, top = 150.dp),
            fontSize = 26.sp,
            text = "Multiplayer"
        )


        NumberPicker(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 30.dp, end = 20.dp),
            value = pickerValue.value,
            onValueChange = {
                pickerValue.value = it
            },
            textStyle = TextStyle(fontSize = 30.sp),
            range = 1..10
        )
        Box(
            modifier
                .align(Alignment.Center)
                .heightIn(300.dp)
                .padding(20.dp)
                .width(
                    250.dp
                )
                .background(color = Color(r, b, g))
        )

        Row(

            modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp)
        ) {
            Column(

            ) {
                Text(
                    text = "R", fontSize = 40.sp, modifier = modifier
                        .padding(end = 70.dp)
                        .align(
                            Alignment.CenterHorizontally
                        )
                )

                Text(
                    text = r.toString(), fontSize = 20.sp, modifier = modifier
                        .padding(end = 70.dp)
                        .align(
                            Alignment.CenterHorizontally
                        )
                )

                Button(
                    onClick = {
                        vm.addR(pickerValue.value)
                    }) {
                    Text(text = "+")
                }
                Button(
                    onClick = { vm.subR(pickerValue.value) }) {
                    Text(text = "-")
                }
            }
            Column(

            ) {
                Text(
                    text = "B",
                    fontSize = 40.sp,
                    modifier = modifier
                        .padding(end = 70.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Text(
                    text = b.toString(), fontSize = 20.sp, modifier = modifier
                        .padding(end = 70.dp)
                        .align(
                            Alignment.CenterHorizontally
                        )
                )
                Button(
                    onClick = { vm.addB(pickerValue.value) }) {
                    Text(
                        text = "+"
                    )
                }
                Button(
                    onClick = { vm.subB(pickerValue.value) }) {
                    Text(text = "-")
                }
            }
            Column(

            ) {
                Text(text = "G", fontSize = 40.sp, modifier = modifier.padding(end = 70.dp))
                Text(
                    text = g.toString(), fontSize = 20.sp, modifier = modifier
                        .padding(end = 70.dp)
                        .align(
                            Alignment.CenterHorizontally
                        )
                )
                Button(
                    onClick = { vm.addG(pickerValue.value) }) {
                    Text(text = "+")
                }
                Button(
                    onClick = { vm.subG(pickerValue.value) }) {
                    Text(text = "-")
                }
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RBGTheme {
        MultiplayerBox(RBGViewModel(), 0, 0, 0)
    }
}