package com.example.componentelayout2


import android.R.attr.value
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componentelayout2.ui.theme.ComponenteLayout2Theme
import com.example.componentelayout2.ui.theme.Righteos

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponenteLayout2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    basicComponentsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )


                }
            }
        }
    }
}


@Composable
fun basicComponentsScreen(modifier: Modifier = Modifier) {



    var textoInput = remember { mutableStateOf("") }
    var qtde = remember { mutableStateOf("") }




    Column(modifier
        .fillMaxSize()
        .background(Color(239, 247, 207))
    ){
        Text(
            text = "Aulas android",
            color = Color(0xFF3DDC84),
            textAlign = TextAlign.End,
            fontFamily = FontFamily.Serif,
            letterSpacing = 4.sp,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 20.dp, 5.dp, 10.dp)




        )



        Text(
            text = "com jetpack Compose",
            color = Color(66,133,244),
            textAlign = TextAlign.Center,
            fontFamily = Righteos,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()



        )

        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center



        ){
            TextField(
                modifier = Modifier
                    .padding(0.dp, 20.dp, 5.dp, 10.dp)
                    .width(350.dp),
                value = textoInput.value,
                label = {
                    Text("Digite seu nome: ")
                },
                onValueChange = {
                        novoValor -> Log.i("Teste", novoValor)

                    textoInput.value = novoValor
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words
                )
            )

            TextField(
                modifier = Modifier
                    .padding(0.dp, 20.dp, 5.dp, 10.dp)
                    .width(350.dp),
                value = qtde.value,
                label = {
                    Text("Digite sua altura em CM: ")
                },
                onValueChange = {
                        novoValor -> Log.i("Teste", novoValor)

                    qtde.value = novoValor
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

        }




    }
}

@Composable
fun AndroidEnemy(color : Color, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(color = color),
        contentDescription = "Android enemy"
    )

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComponenteLayout2Theme {
        Greeting("Android")
    }
}