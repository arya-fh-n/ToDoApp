package com.dicoding.todoapp.ui.detail

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.todoapp.R
import com.dicoding.todoapp.ui.ViewModelFactory
import com.dicoding.todoapp.ui.list.TaskActivity
import com.dicoding.todoapp.utils.DateConverter
import com.dicoding.todoapp.utils.TASK_ID
import com.google.android.material.textfield.TextInputEditText

class DetailTaskActivity : AppCompatActivity() {

    private lateinit var detailTaskViewModel: DetailTaskViewModel
    private lateinit var edtTitle: TextInputEditText
    private lateinit var edtDesc: TextInputEditText
    private lateinit var edtDueDate: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        val factory = ViewModelFactory.getInstance(this)
        detailTaskViewModel = ViewModelProvider(this, factory).get(DetailTaskViewModel::class.java)
        //TODO 11 : Show detail task and implement delete action
        val taskId = intent.getIntExtra(TASK_ID, 0)
        Log.d("DetailTask", "Task ID : $taskId")
        detailTaskViewModel.setTaskId(taskId)

        edtTitle = findViewById(R.id.detail_ed_title)
        edtDesc = findViewById(R.id.detail_ed_description)
        edtDueDate = findViewById(R.id.detail_ed_due_date)

        detailTaskViewModel.task.observe(this) { task ->
            Log.d("DetailTaskDetails2", "Task : $task")
            task?.let {
                edtTitle.setText(it.title)
                edtDesc.setText(it.description)
                edtDueDate.setText(DateConverter.convertMillisToString(it.dueDateMillis))
            }
        }

        findViewById<Button>(R.id.btn_delete_task).setOnClickListener {
            detailTaskViewModel.deleteTask()
            startActivity(Intent(this@DetailTaskActivity, TaskActivity::class.java))
            finish()
        }
    }
}