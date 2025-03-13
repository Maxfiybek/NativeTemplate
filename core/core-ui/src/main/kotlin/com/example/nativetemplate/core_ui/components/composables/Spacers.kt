package com.example.nativetemplate.core_ui.components.composables

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ColumnScope.FillSpace() { Spacer(modifier = Modifier.weight(1F)) }

@Composable
fun RowScope.FillSpace() { Spacer(modifier = Modifier.weight(1F)) }

@Composable
fun Spacer2() { Spacer(modifier = Modifier.size(2.dp)) }

@Composable
fun Spacer4() { Spacer(modifier = Modifier.size(4.dp)) }

@Composable
fun Spacer8() { Spacer(modifier = Modifier.size(8.dp)) }

@Composable
fun Spacer10() { Spacer(modifier = Modifier.size(10.dp)) }

@Composable
fun Spacer12() { Spacer(modifier = Modifier.size(12.dp)) }

@Composable
fun Spacer16() { Spacer(modifier = Modifier.size(16.dp)) }

@Composable
fun Spacer32() { Spacer(modifier = Modifier.size(32.dp)) }

@Composable
fun Spacer40() { Spacer(modifier = Modifier.size(40.dp)) }

@Composable
fun Spacer64() { Spacer(modifier = Modifier.size(64.dp)) }