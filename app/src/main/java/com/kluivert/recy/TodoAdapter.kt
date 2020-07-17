package com.kluivert.recy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_layout.view.*

class TodoAdapter(
    var todo : List<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {


    inner class TodoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.todo_layout,parent,false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
       return todo.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.apply {
            tvTitle.text = todo[position].title
            cbDone.isChecked = todo[position].isChecked

        }
    }
}