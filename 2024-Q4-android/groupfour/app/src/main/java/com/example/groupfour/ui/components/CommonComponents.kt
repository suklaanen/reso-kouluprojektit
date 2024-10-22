package com.example.groupfour.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.groupfour.ui.theme.LightestBrown
import com.example.groupfour.ui.theme.SolidBlue

@Composable
fun Heading(
    title: String,
    modifier: Modifier = Modifier,
    fontSize: Int = 24,
    backgroundColor: Color = LightestBrown.copy(alpha = 0.7f),
    textColor: Color = SolidBlue
) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .background(backgroundColor, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontSize = fontSize.sp,
            textAlign = TextAlign.Center,
            color = textColor,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun AccountSection(
    navController: NavController,
    titleRes: Int,
    modifier: Modifier = Modifier,
    backgroundColor: Color = LightestBrown.copy(alpha = 0.7f),
    content: @Composable () -> Unit

) {

    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(backgroundColor, RoundedCornerShape(8.dp))
            .padding(2.dp)
    ) {
        Column {
            Heading(title = stringResource(titleRes))
            content()
        }
    }
}

@Composable
fun CommonText(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(fontSize = 16.sp),
    backgroundColor: Color = LightestBrown.copy(alpha = 0.5f),
    cornerRadius: Dp = 8.dp,
    editable: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailingIcon: @Composable() (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .background(backgroundColor, RoundedCornerShape(cornerRadius))
            .padding(8.dp)
    ) {
        if (editable) {
            TextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = textStyle,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                trailingIcon = trailingIcon,
                visualTransformation = visualTransformation
            )
        } else {
            Text(
                text = value,
                style = textStyle,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}