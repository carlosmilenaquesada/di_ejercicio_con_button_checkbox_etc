package com.example.di_ejercicio_con_button_checkbox_etc


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.text.style.TextAlign
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
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.Red),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        // 1. Un botón con el texto 'Presionar' que, al hacer clic, actualizará el mensaje en el
        // campo de texto con 'Botón presionado' y mostrará un `CircularProgressIndicator` durante 5
        // segundos.
        var textoBoton by rememberSaveable {
            mutableStateOf("Presionar")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround


        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight(), contentAlignment = Alignment.Center
            ) {
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                    onClick = {
                        textoBoton = if (textoBoton == "Presionar") {
                            "Botón presionado"
                        } else {
                            "Presionar"
                        }
                    }) {
                    Text(text = textoBoton)
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f), contentAlignment = Alignment.Center
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
        Column(
            modifier = Modifier
                .background(Color.LightGray),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            // 2. Un campo de texto que mostrará un mensaje, inicialmente no visible.
            var mostrarMensaje by rememberSaveable {
                mutableStateOf(true)
            }
            Box(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                        .background(Color.Gray)
                        .padding(10.dp),
                    text = if (mostrarMensaje) {
                        "Este mensaje está inicalmente oculto, solo se muestra cuando se" +
                                "marca el checkbox"
                    } else {
                        ""
                    },

                    textAlign = TextAlign.Justify
                )

            }
            // 3. Una casilla de verificación (checkbox) con el texto 'Activar' que, al marcarla,
            // mostrará el Text anterior
            Row(
                modifier = Modifier

                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(
                    checked = mostrarMensaje,
                    onCheckedChange = {
                        mostrarMensaje = !mostrarMensaje
                    }
                )
                Text(text = "Activar texto oculto")
            }

        }
        // 4. Un icono de tu elección que se mostrará siempre en la interfaz.
        Icon(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan),
            imageVector = Icons.Rounded.Face,
            contentDescription = "Icono",
            tint = Color.Red
        )

        Column(
            modifier = Modifier
                .background(Color.Red)
                .padding(10.dp)

        ) {
            // 5. Un interruptor (switch) que mostrará en grupo de botones siguiente(punto 6)
            var estadoSwitch by rememberSaveable {
                mutableStateOf(true)
            }
            Row(
                modifier = Modifier
                    .background(Color.LightGray)
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Switch(
                    modifier = Modifier.weight(0.5f),
                    checked = estadoSwitch,
                    onCheckedChange = { estadoSwitch = !estadoSwitch })
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Activar/Desactivar radio button group"
                )
            }
            // 6. Un grupo de botones de radio (radiobutton) con al menos tres opciones distintas
            // que permitirá al usuario seleccionar una opción y actualizar el mensaje del campo de
            // texto en consecuencia
            Column(
                modifier = Modifier
                    .background(Color.Gray)
                    .fillMaxWidth()
                    .padding(10.dp)

            ) {
                var radioButtonElegido by rememberSaveable {
                    mutableStateOf("Opción 1")
                }
                Column(modifier = Modifier.height(200.dp)) {
                    if (estadoSwitch) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = radioButtonElegido == "Opción 1",
                                onClick = { radioButtonElegido = "Opción 1" })
                            Text(text = "Opción 1")
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = radioButtonElegido == "Opción 2",
                                onClick = { radioButtonElegido = "Opción 2" })
                            Text(text = "Opción 2")
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(
                                selected = radioButtonElegido == "Opción 3",
                                onClick = { radioButtonElegido = "Opción 3" })
                            Text(text = "Opción 3")
                        }

                        Text(text = "El botón elegido es: $radioButtonElegido")
                    }
                }
            }
        }

        // 7. Una imagen que se actualizará al hacer clic en el botón. La imagen puede cambiar entre al menos
        //tres imágenes diferentes.
        Column(
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            var imagen by rememberSaveable {
                mutableStateOf(R.drawable.gato)
            }
            Image(painter = painterResource(id = imagen), contentDescription = "animal")

            Button(onClick = {

                imagen = cambiarImagen(imagen)
            }) {
                Text(text = "Cambiar imagen")
            }
        }
    }
}

fun cambiarImagen(numeroImagen: Int): Int {
    return if (numeroImagen == R.drawable.gato) {
        R.drawable.perro
    } else {
        if (numeroImagen == R.drawable.perro) {
            R.drawable.loro
        } else {
            if (numeroImagen == R.drawable.loro) {
                R.drawable.gato
            } else {
                R.drawable.gato
            }
        }
    }
}