package com.dicoding.todoapp.ui.detail

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.todoapp.R
import com.dicoding.todoapp.data.Task
import com.dicoding.todoapp.utils.TASK_ID

class DetailTaskActivity : AppCompatActivity() {

    private lateinit var detailTaskViewModel: DetailTaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        //TODO 11 : Show detail task and implement delete action
        val intent = intent.getParcelableExtra<Task>(TASK_ID)

        if (intent != null) {
            detailTaskViewModel.setTaskId(intent.id)
            findViewById<TextView>(R.id.title).text = intent.title
            findViewById<TextView>(R.id.detail_ed_description).text = intent.description
            findViewById<TextView>(R.id.detail_ed_due_date).text = intent.dueDateMillis.toString()
        }

        findViewById<Button>(R.id.btn_delete_task).setOnClickListener {
            detailTaskViewModel.deleteTask()
        }
    }
}