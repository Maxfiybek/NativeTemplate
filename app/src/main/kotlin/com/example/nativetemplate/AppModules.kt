package com.example.nativetemplate

import com.example.nativetemplate.core.di.netWorkModule
import com.example.nativetemplate.data.di.dataModule
import com.example.nativetemplate.splash.di.splashModule

val appModules = listOf(
    netWorkModule,
    dataModule,
    splashModule
)