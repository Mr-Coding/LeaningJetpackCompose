package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.os.Environment
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.Typeface
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.io.File

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting(ctx = this)
        }
    }
}

@Composable
fun Greeting(ctx:Context) {
    val file1 = File(ctx.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS),"/")
    val file2 = File(file1,"/HELLO.otf")
    val typeFace2 = android.graphics.Typeface.createFromFile(file2)
    println("测试：$file2")
    println("\n----------------------------------------------")

   Column (
       modifier = Modifier.fillMaxSize(),
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.Center
           ){
       Box{ Text(
           text = "09:50",
           fontSize = 120.sp,
           fontFamily = FontFamily(typeFace2)
       )}
       Box{ Text(
           text = "2021年03月09日 PM 星期二 10s",
           fontSize = 30.sp,
           fontFamily = FontFamily(typeFace2)
       )}
   }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Greeting(LocalContext.current)
}