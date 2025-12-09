package app.application.mayoredad.ui.componentes
// Componente reutilizable de botón

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ButtonUi(text: String, onClick: () -> Unit) {
    // Botón reutilizable que recibe un texto y una función al hacer clic
    Button(onClick = onClick) {
        Text(text)  // Texto mostrado dentro del botón
    }
}
