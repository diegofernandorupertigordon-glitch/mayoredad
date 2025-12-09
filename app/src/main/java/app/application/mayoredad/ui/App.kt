package app.application.mayoredad.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.shape.RoundedCornerShape
import app.application.mayoredad.ui.componentes.ButtonUi
import app.application.mayoredad.ui.componentes.TextFieldUi
import app.application.mayoredad.ui.componentes.TextUi

@Preview(showBackground = true)
@Composable
fun App() {

    var nombre by rememberSaveable { mutableStateOf("") }
    var edad by rememberSaveable { mutableStateOf("") }
    var mostrarDialogo by rememberSaveable { mutableStateOf(false) }
    var mensaje by rememberSaveable { mutableStateOf("") }

    // Validación
    var errorNombre by rememberSaveable { mutableStateOf("") }
    var errorEdad by rememberSaveable { mutableStateOf("") }

    Scaffold { padding ->

        // CENTRAR TODO
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // CARD MODERNA
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFEFF5FF) // azul muy suave
                ),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {

                Column(modifier = Modifier.padding(20.dp)) {

                    TextUi("Comprobemos tu edad")

                    Spacer(modifier = Modifier.height(20.dp))

                    // Etiqueta nombre
                    Text("Ingresa tu nombre:")

                    TextFieldUi(
                        value = nombre,
                        onValueChange = {
                            nombre = it
                            errorNombre = ""
                        },
                        isNumeric = false
                    )

                    // Error nombre
                    if (errorNombre.isNotEmpty()) {
                        Text(
                            text = errorNombre,
                            color = Color.Red
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Etiqueta edad
                    Text("Ingresa tu edad:")

                    TextFieldUi(
                        value = edad,
                        onValueChange = {
                            edad = it
                            errorEdad = ""
                        },
                        isNumeric = true
                    )

                    // Error edad
                    if (errorEdad.isNotEmpty()) {
                        Text(
                            text = errorEdad,
                            color = Color.Red
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    ButtonUi("Verificar") {

                        var valido = true

                        // Validación nombre
                        if (nombre.isBlank()) {
                            errorNombre = "El nombre no puede estar vacío"
                            valido = false
                        }

                        // Validación edad
                        if (edad.isBlank()) {
                            errorEdad = "Debes ingresar tu edad"
                            valido = false
                        } else if (edad.toIntOrNull() == null) {
                            errorEdad = "Ingresa solo números"
                            valido = false
                        }

                        if (valido) {
                            val edadInt = edad.toInt()

                            mensaje = if (edadInt >= 18) {
                                "$nombre eres mayor de edad."
                            } else {
                                "$nombre eres menor de edad."
                            }

                            mostrarDialogo = true
                        }
                    }
                }
            }

            // DIALOGO
            if (mostrarDialogo) {
                AlertDialog(
                    onDismissRequest = {
                        mostrarDialogo = false
                        nombre = ""
                        edad = ""
                    },
                    confirmButton = {
                        Button(onClick = {
                            mostrarDialogo = false
                            nombre = ""
                            edad = ""
                        }) {
                            Text("Cerrar")
                        }
                    },
                    title = { Text("Resultado") },
                    text = { Text(mensaje) }
                )
            }
        }
    }
}
