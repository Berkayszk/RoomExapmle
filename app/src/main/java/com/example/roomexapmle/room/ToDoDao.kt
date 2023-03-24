package com.example.roomexapmle.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomexapmle.model.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todo:Todo)


    @Query("SELECT * FROM todo ORDER BY todoTitle ASC")
    fun getAllToDo() : Flow<List<Todo>>
}