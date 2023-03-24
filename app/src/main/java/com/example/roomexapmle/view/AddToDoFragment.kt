package com.example.roomexapmle.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.roomexapmle.R
import com.example.roomexapmle.databinding.FragmentAddToDoBinding

class AddToDoFragment : Fragment(R.layout.fragment_add_to_do) {
    private var _binding : FragmentAddToDoBinding?=null
    private val binding get() = _binding!!
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
    }
}