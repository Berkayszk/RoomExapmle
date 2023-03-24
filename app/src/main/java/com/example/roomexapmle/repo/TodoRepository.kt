package com.example.roomexapmle.repo

import com.example.roomexapmle.model.Todo
import com.example.roomexapmle.room.ToDoDao
import javax.inject.Inject

class TodoRepository @Inject constructor(private val dao : ToDoDao){

    suspend fun insertTodo(todo : Todo) = dao.insertTodo(todo)

    fun getAllToDo() = dao.getAllToDo()
}