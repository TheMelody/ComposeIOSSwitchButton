package com.melody.switch.demo

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * 仅支持点击
 * @author TheMelody
 * email developer_melody@163.com
 * created 2022/7/16 10:09
 */
@Composable
fun IosSwitchButtonStyle1(
    modifier: Modifier,
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit),
    width: Dp = 49.dp,
    height: Dp = 30.dp,
    checkedTrackColor: Color = Color(0xFF4D7DEE),
    uncheckedTrackColor: Color = Color(0xFFC7C7C7),
    gapBetweenThumbAndTrackEdge: Dp = 2.dp
){
    val switchONState = remember { mutableStateOf(checked) }
    val thumbRadius = (height / 2) - gapBetweenThumbAndTrackEdge

    val animatePosition by animateFloatAsState(
        targetValue = if (checked)
            with(LocalDensity.current) { (width - thumbRadius - gapBetweenThumbAndTrackEdge).toPx() }
        else
            with(LocalDensity.current) { (thumbRadius + gapBetweenThumbAndTrackEdge).toPx() }
    )

    val animateTrackColor by animateColorAsState(
        targetValue = if (checked) checkedTrackColor else uncheckedTrackColor
    )
    Canvas(
        modifier = modifier
            .size(width = width, height = height)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        switchONState.value = !switchONState.value
                        onCheckedChange.invoke(switchONState.value)
                    }
                )
            }
    ) {
        // Track
        drawRoundRect(
            color = animateTrackColor,
            cornerRadius = CornerRadius(x = height.toPx(), y = height.toPx()),
        )

        // Thumb
        drawCircle(
            color = Color.White,
            radius = thumbRadius.toPx(),
            center = Offset(
                x = animatePosition,
                y = size.height / 2
            )
        )
    }
}