package com.example.componentelayout2


import android.R.attr.checked
import android.R.attr.contentDescription
import android.R.attr.text
import android.R.attr.value
import android.R.id.checkbox
import android.os.Bundle
import android.util.Log
import android.util.Log.i
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Label
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
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



    var textoInput by remember { mutableStateOf("") }
    var qtde by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var checkKotlin by remember { mutableStateOf(false) }
    var checkJava by remember { mutableStateOf(false) }
    var checkNode by remember { mutableStateOf(false) }
    var radioEscolha by remember { mutableStateOf(0) }
    var corFundo by remember { mutableStateOf(Color(239, 247, 207)) }
    var favoritado by remember { mutableStateOf(false) }



    Column(modifier
        .fillMaxSize()
        .background(corFundo)
    ) {
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
            color = Color(66, 133, 244),
            textAlign = TextAlign.Center,
            fontFamily = Righteos,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()


        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                modifier = Modifier

                    .width(350.dp),
                value = textoInput,
                placeholder = {
                    Text(text = "Digite seu nome: ")
                },
                label = {
                    Text(text = "Nome")
                },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Blue,
                    unfocusedTextColor = Color.Red,
                    unfocusedPlaceholderColor = Color.Magenta
                ),
                onValueChange = { novoValor ->
                    Log.i("Teste", novoValor)

                    textoInput = novoValor
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Ícone de pessoa",
                        tint = Color(66, 133, 244)
                    )
                },

                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Ícone de pessoa",
                        tint = Color(66, 133, 244)
                    )
                },
                singleLine = true

            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                modifier = Modifier

                    .width(350.dp),
                value = qtde,
                placeholder = {
                    Text(text = "Digite a quantidade: ")
                },
                label = {
                    Text(text = "Quantidade")
                },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Blue,
                    unfocusedTextColor = Color.LightGray,
                    unfocusedPlaceholderColor = Color.Red
                ),
                onValueChange = { novoValor ->
                    Log.i("Teste", novoValor)

                    qtde = novoValor
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                modifier = Modifier
                    .width(350.dp),
                value = email,
                onValueChange = { email = it },
                placeholder = {
                    Text(text = "Digite o seu email: ")
                },
                label = {
                    Text(text = "E-mail")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,

                shape = RoundedCornerShape(
                    topStart = 32.dp,
                    bottomEnd = 32.dp
                ),

                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.Red
                ),


                )

            Spacer(modifier = Modifier.height(16.dp))

        }



        Column() {

            Text("CHECKBOX")

            Row(verticalAlignment = Alignment.CenterVertically) {




                Checkbox(
                    checked = checkKotlin,
                    onCheckedChange = { checkKotlin = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Blue,
                        uncheckedColor = Color.Red
                    )
                )

                Text(text = "Kotlin")
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checkJava,
                    onCheckedChange = { checkJava = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Blue,
                        uncheckedColor = Color.Red
                    )
                )

                Text(text = "Java")
            }


            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = checkNode,
                    onCheckedChange = { checkNode = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Blue,
                        uncheckedColor = Color.Red
                    )
                )

                Text(text = "Node.js")
            }


            Text(text = "RADIO BUTTON")

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = radioEscolha == 0,
                    onClick = {radioEscolha = 0 }
                )



                Text(text = "MacOS")
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = radioEscolha == 1,
                    onClick = {radioEscolha = 1}
                )



                Text(
                    text = "Linux",

                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = radioEscolha == 2,
                    onClick = {radioEscolha = 2}
                )



                Text(text = "Windowns")
            }



        }
        


        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround

        ) {

            Button(
                onClick = {
                    corFundo = Color(232, 151, 191, 255)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(253, 101, 0, 255)
                ),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp)

            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {


                    Icon(
                        painterResource(R.drawable.outline_arrow_right_alt_24),
                        contentDescription = "imagem de seta para direita"
                    )
                    Text(
                        text = "salvar"
                    )

                }


            }



            Button(
                onClick = {
                    corFundo = Color(240, 230, 220)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(253, 101, 0, 255)
                ),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp)

            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {


                    Icon(
                        painterResource(R.drawable.outline_arrow_left_alt_24),
                        contentDescription = "imagem de seta para esquerda"
                    )
                    Text(
                        text = "cancelar"
                    )

                }


            }



        }

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
            ){
            if(favoritado){
                Icon(
                    modifier = Modifier.size(40.dp)
                        .clickable{favoritado = false},
                    contentDescription = "Imagem de favorito",
                    imageVector = Icons.Default.Favorite
                )
            }else{
                Icon(
                    modifier = Modifier.size(40.dp)
                        .clickable{favoritado = true},
                    contentDescription = "Imagem de favorito",
                    imageVector = Icons.Default.FavoriteBorder
                )
            }
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