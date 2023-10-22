package com.example.di_ejercicio_con_button_checkbox_etc


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.di_ejercicio_con_button_checkbox_etc.ui.theme.Di_ejercicio_con_button_checkbox_etcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Di_ejercicio_con_button_checkbox_etcTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Principal()
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Principal() {
    Column {
        var textoBoton by rememberSaveable {
            mutableStateOf("Presionar")
        }
        Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
            Button(modifier = Modifier
                .padding(5.dp)
                .width(200.dp)
                .weight(1f), onClick = {
                if (textoBoton == "Presionar") {
                    textoBoton = "Botón presionado"
                } else {
                    textoBoton = "Presionar"
                }
            }) {
                Text(text = textoBoton)
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
            ) {
                if (textoBoton == "Botón presionado") {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center),
                        color = Color.Green,
                        strokeWidth = 2.dp
                    )
                }
            }
        }
        Column(modifier = Modifier.weight(2f)) {
            var mostrarMensaje by rememberSaveable {
                mutableStateOf(false);
            }
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(
                    modifier = Modifier,

                    checked = mostrarMensaje,
                    onCheckedChange = {
                        mostrarMensaje = !mostrarMensaje
                    }
                )
                Text(text = "Activar texto oculto")
            }
            Box(modifier = Modifier.weight(1f)) {
                if (mostrarMensaje == true) {
                    Text(
                        modifier = Modifier.padding(15.dp),
                        text = "Este mensaje está inicalmente oculto, solo se muestra cuando se marca el checkbox"
                    )
                }
            }
        }
        Icon(
            modifier = Modifier.weight(0.5f),
            imageVector = Icons.Rounded.Face,
            contentDescription = "Icono",
            tint = Color.Red
        )

        Column(modifier = Modifier.weight(5f)) {
            var estadoSwitch by rememberSaveable {
                mutableStateOf(false)
            }

            Row(modifier = Modifier.weight(1f)) {
                Switch(
                    modifier = Modifier.weight(1f),
                    checked = estadoSwitch,
                    onCheckedChange = { estadoSwitch = !estadoSwitch })
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Activar/Desactivar radio button group"
                )
            }
            Column(modifier = Modifier.weight(4f)) {
                var radioButtonElegido by rememberSaveable {
                    mutableStateOf("Button 1")
                }

                if (estadoSwitch) {
                    Column {
                        Row {
                            RadioButton(
                                selected = radioButtonElegido == "Button 1",
                                onClick = { radioButtonElegido = "Button 1" })
                            Text(text = "Opción 1")
                        }
                        Row {
                            RadioButton(
                                selected = radioButtonElegido == "Button 2",
                                onClick = { radioButtonElegido = "Button 2" })
                            Text(text = "Opción 2")
                        }
                        Row {
                            RadioButton(
                                selected = radioButtonElegido == "Button 3",
                                onClick = { radioButtonElegido = "Button 3" })
                            Text(text = "Opción 3")
                        }

                        Text(text = "El botón elegido es el " + radioButtonElegido)
                    }
                }
            }
        }

        Box(modifier = Modifier.weight(3f)) {
            var imagen by rememberSaveable {
                mutableStateOf(1)
            }
            Image(painter = painterResource(id = imagen), contentDescription = "animal")

            Button(onClick = {
                imagen = cambiarNumero(imagen)
            }) {
                Text(text = "Cambiar imagen")
            }
        }
    }
}

fun cambiarNumero(numero: Int): Int {
    if (numero == 1) {
        return 2;
    } else {
        if (numero == 2) {
            return 3;
        } else {
            if (numero == 3) {
                return 1;
            } else {
                return numero;
            }
        }
    }
}