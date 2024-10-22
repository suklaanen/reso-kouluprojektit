package com.example.groupfour.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button as M3Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groupfour.ui.theme.PureWhite
import com.example.groupfour.ui.theme.SolidBlue

@Composable
fun ButtonContinue (
    title: String,
    modifier: Modifier = Modifier,
    fontSize: Int = 24,
    backgroundColor: Color = SolidBlue,
    textColor: Color = PureWhite,
    onClick: () -> Unit
) {
    M3Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor,
        ),
        shape = RoundedCornerShape(12.dp),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge.copy(fontSize = fontSize.sp),
        )
    }
}
