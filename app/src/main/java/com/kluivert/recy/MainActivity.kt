package com.kluivert.recy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var todoList = mutableListOf(
            Todo("We are Progressing", true),
            Todo("Messed up slightly tho", true),
            Todo("Kinda unhappy tho", true),
            Todo("Let's get better", false),
            Todo("Need you bae", true),
            Todo("I'm awesome", false),
            Todo("Hey Kluivert", false)
        )

        var adapter = TodoAdapter(todoList)
        rvTodo.adapter = adapter
        rvTodo.layoutManager = LinearLayoutManager(this)


        btnAdd.setOnClickListener {
            var title = edTodo.text.toString()
            var todos = Todo(title,true)
            todoList.add(todos)
            adapter.notifyItemInserted(todoList.size -1 )
        }

    }


}