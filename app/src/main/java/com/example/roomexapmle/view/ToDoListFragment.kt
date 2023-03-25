package com.example.roomexapmle.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomexapmle.R
import com.example.roomexapmle.adapter.TodoAdapter
import com.example.roomexapmle.databinding.FragmentToDoListBinding
import com.example.roomexapmle.model.Todo
import com.example.roomexapmle.viewmodel.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ToDoListFragment : Fragment(R.layout.fragment_to_do_list) {
    private var _binding : FragmentToDoListBinding?=null
    private val binding get() = _binding!!
    private lateinit var todoAdapter : TodoAdapter

    private val viewModel: TodoViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentToDoListBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabAddToDo.setOnClickListener {
            view.findNavController().navigate(
                R.id.action_toDoListFragment_to_addToDoFragment
            )
        }
        setUpRecyclerView()

    }
    private fun setUpRecyclerView(){
        todoAdapter = TodoAdapter()
        binding.rvListToDo.apply {
            adapter = todoAdapter
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
        }
        viewModel.getAllToDos.observe(viewLifecycleOwner, Observer {listTodo->
            updateUi(listTodo)
            todoAdapter.differ.submitList(listTodo)

        }) }
    private fun updateUi(list:List<Todo>){
        if (list.isNotEmpty()){
            binding.rvListToDo.visibility = View.VISIBLE
            binding.cardViewTvNoTodo.visibility = View.GONE
        }else{
            binding.rvListToDo.visibility = View.GONE
            binding.cardViewTvNoTodo.visibility = View.VISIBLE

        }
    }
}