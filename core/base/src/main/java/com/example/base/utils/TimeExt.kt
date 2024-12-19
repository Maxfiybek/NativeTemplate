package com.example.base.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun getCurrentTime() = SimpleDateFormat("dd-mm-yyyy", Locale.getDefault()).format(Date())

