package com.filbabic.androidacademy.ui.common

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PrimaryButton(
    isEnabled: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit = {},
    onClick: () -> Unit = {}
) {
    val buttonColors = ButtonDefaults.buttonColors().copy(
        containerColor = if (isEnabled) ButtonDefaults.buttonColors().containerColor else ButtonDefaults.buttonColors().disabledContainerColor,
        contentColor = if (isEnabled) ButtonDefaults.buttonColors().contentColor else ButtonDefaults.buttonColors().disabledContentColor
    )
    Button(
        colors = buttonColors,
        enabled = isEnabled,
        modifier = modifier,
        content = content,
        onClick = onClick
    )
}

@Preview
@Composable
fun PrimaryButtonEnabled() {
    PrimaryButton(
        isEnabled = true,
    )
}


@Preview
@Composable
fun PrimaryButtonDisabled(
) {
    PrimaryButton(
        isEnabled = false,
    )
}