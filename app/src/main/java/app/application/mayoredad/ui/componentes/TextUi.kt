package app.application.mayoredad.ui.componentes
// Componente para textos personalizados

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TextUi(text: String) {
    // Texto reutilizable con estilo personalizado
    Text(
        text = text,
        fontSize = 22.sp,               // Tamaño grande
        fontWeight = FontWeight.Bold    // Negrita
    )
}
