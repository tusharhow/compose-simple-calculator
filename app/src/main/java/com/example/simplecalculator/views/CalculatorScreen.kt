package com.example.simplecalculator.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp


@SuppressLint("UnrememberedMutableState")
@Composable
fun CalculatorScreen() {

    val calculate = remember { mutableStateOf("") }

    Column(
        horizontalAlignment =  Alignment.CenterHorizontally,
       verticalArrangement =  Arrangement.Center,

    ) {
        TextField(
            value = calculate.value,
            onValueChange = {
            calculate.value = it
        })

        Button(onClick = {
          val  res =  calculate(calculate.value)
            calculate.value = res
            println("result: $res")
        }) {
            Text("Calculate")
        }
        Text(calculate.value, style =  TextStyle(fontSize = 20.sp))
    }
}


fun calculate(input: String): String {
    var result = 0
    val split = input.split(" ")
    for (i in split) {
        result += if (i.contains("+")) {
            val split = i.split("+")
            split[0].toInt() + split[1].toInt()
        } else if (i.contains("-")) {
            val split = i.split("-")
            split[0].toInt() - split[1].toInt()
        } else if (i.contains("*")) {
            val split = i.split("*")
            split[0].toInt() * split[1].toInt()
        } else if (i.contains("/")) {
            val split = i.split("/")
            split[0].toInt() / split[1].toInt()
        } else {
            i.toInt()
        }
    }
    return result.toString()
}