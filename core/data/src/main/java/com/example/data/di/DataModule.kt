package com.example.data.di

import androidx.room.Room
import com.example.data.database.AppDatabase
import org.koin.dsl.module
import com.example.data.localStorage.LocalStorage

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