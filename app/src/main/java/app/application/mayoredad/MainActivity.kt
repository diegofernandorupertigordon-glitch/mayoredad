package app.application.mayoredad
// Paquete principal de la aplicación

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import app.application.mayoredad.ui.App           // Importamos nuestro Composable principal
import app.application.mayoredad.ui.theme.MayoredadTheme  // Tema de la app

class MainActivity : ComponentActivity() {
    // Activity principal, punto de entrada de la app

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        // Habilita modo pantalla completa sin bordes

        setContent {
            // Define el contenido en Jetpack Compose

            MayoredadTheme {
                // Aplica el tema visual de la app

                Surface(color = MaterialTheme.colorScheme.background) {
                    // Surface es una capa base con color de fondo

                    App()   // Llamamos a la pantalla principal creada en Compose
                }
            }
        }
    }
}
