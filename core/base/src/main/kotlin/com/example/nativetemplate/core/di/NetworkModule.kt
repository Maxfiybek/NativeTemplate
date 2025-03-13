package com.example.nativetemplate.core.di

import com.example.nativetemplate.core.ktorclient.createHttpClient
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val netWorkModule = module {
    single<Json> {
        Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
            encodeDefaults = true
        }
    }
    singleOf(::createHttpClient)
}