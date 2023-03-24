package com.example.roomexapmle.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.roomexapmle.R
import com.example.roomexapmle.databinding.FragmentToDoListBinding

class ToDoListFragment : Fragment(R.layout.fragment_to_do_list) {
    private var _binding : FragmentToDoListBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
    }

}