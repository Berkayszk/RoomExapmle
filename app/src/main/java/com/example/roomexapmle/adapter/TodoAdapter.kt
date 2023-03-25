package com.example.roomexapmle.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.roomexapmle.databinding.FragmentToDoListBinding
import com.example.roomexapmle.databinding.TodoRowBinding
import com.example.roomexapmle.model.Todo

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

   inner class TodoViewHolder(val binding : TodoRowBinding) : RecyclerView.ViewHolder(binding.root)

   private fun diffCallBack()= object : DiffUtil.ItemCallback<Todo>(){
      override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem.id==newItem.id
      }

      override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem==newItem
      }

   }

   val differ = AsyncListDiffer(this,diffCallBack())

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
      return TodoViewHolder(TodoRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
   }

   override fun getItemCount() = differ.currentList.size

   override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
      val todo = differ.currentList[position]
      holder.binding.apply {
         toDotitle.text = todo.todoTitle
      }
      holder.binding.checkBox.apply {
         setOnClickListener {
            holder.binding.apply {
               if(isChecked){
                  toDotitle.paintFlags = toDotitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
               }else{
                  toDotitle.paintFlags = toDotitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
               }
            }
         }
      }
   }



}