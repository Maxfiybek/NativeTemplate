package com.example.nativetemplate.data.di

import androidx.room.Room
import com.example.nativetemplate.data.database.AppDatabase
import com.example.nativetemplate.data.localStorage.LocalStorage
import org.koin.dsl.module

val dataModule = module {
    single<LocalStorage> {
        LocalStorage.init(context = get())
        LocalStorage.instance
    }
    single<AppDatabase> {
        Room.databaseBuilder(
            context = get(),
            klass = AppDatabase::class.java,
            name = "app_database"
        ).build()
    }
}