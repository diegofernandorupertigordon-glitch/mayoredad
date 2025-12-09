package app.application.mayoredad.ui.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.border
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun TextFieldUi(
    value: String,
    onValueChange: (String) -> Unit,
    isNumeric: Boolean,
    enabled: Boolean = true
) {
    OutlinedTextField(
        value = value,
        onValueChange = { input ->

            if (isNumeric) {
                // SOLO NÚMEROS + MAX 3 DÍGITOS
                if (input.all { it.isDigit() } && input.length <= 3) {
                    onValueChange(input)
                }
            } else {
                onValueChange(input)
            }
        },
        enabled = enabled,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(12.dp))
    )
}
