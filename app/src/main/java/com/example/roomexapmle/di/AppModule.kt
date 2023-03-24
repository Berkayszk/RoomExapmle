package com.example.roomexapmle.di

import android.content.Context
import androidx.room.Room
import com.example.roomexapmle.room.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideToDoDatabase(
        @ApplicationContext context : Context
    ) = Room.databaseBuilder(context,TodoDatabase::class.java,"todo_db").build()

    @Singleton
    @Provides
    fun provideTodoDao(db : TodoDatabase) = db.todoDao()

}