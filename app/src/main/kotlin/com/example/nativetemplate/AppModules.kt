package com.example.nativetemplate

import com.example.base.di.netWorkModule
import com.example.data.di.dataModule
import com.example.splash.di.splashModule

val appModules = listOf(
    netWorkModule,
    dataModule,
    splashModule
)