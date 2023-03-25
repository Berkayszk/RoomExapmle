package com.example.roomexapmle.view

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.roomexapmle.R
import com.example.roomexapmle.databinding.FragmentAddToDoBinding
import com.example.roomexapmle.model.Todo
import com.example.roomexapmle.viewmodel.TodoViewModel
import com.google.android.material.snackbar.Snackbar

class AddToDoFragment : Fragment(R.layout.fragment_add_to_do) {
    private var _binding : FragmentAddToDoBinding?=null
    private val binding get() = _binding!!
    private val viewModel : TodoViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddToDoBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCancel.setOnClickListener {
            view.findNavController().navigate(
                R.id.action_addToDoFragment_to_toDoListFragment
            )
        }
        binding.btnAdd.setOnClickListener {mView->
            saveTodo(mView)
        }
    }
    private fun saveTodo(mView: View){
        val todoName = binding.toDoTitle.text.toString()
        if (todoName.isNotEmpty()){
            val todo = Todo(0,todoName)
            viewModel.insertTodo(todo)
            Snackbar.make(mView,"To Do added", Snackbar.LENGTH_SHORT).show()

            mView.findNavController().navigate(R.id.action_addToDoFragment_to_toDoListFragment)
        }else{
            val toast = Toast.makeText(activity,"To Do title cannot be empty",Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER,0,0)
            toast.show()
        }
    }
}