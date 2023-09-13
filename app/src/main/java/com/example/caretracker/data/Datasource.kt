package com.example.caretracker.data

import com.example.caretracker.R
import com.example.caretracker.model.Task

class Datasource {

    fun generateTasks(): List<Task> {
        return listOf(
            Task(taskTitleId = R.string.task_title_1, taskDescId = R.string.task_desc_1),
            Task(taskTitleId = R.string.task_title_2, taskDescId = R.string.task_desc_2),
            Task(taskTitleId = R.string.task_title_3, taskDescId = R.string.task_desc_3),
            Task(taskTitleId = R.string.task_title_4, taskDescId = R.string.task_desc_4),
            Task(taskTitleId = R.string.task_title_5, taskDescId = R.string.task_desc_5),
            Task(taskTitleId = R.string.task_title_6, taskDescId = R.string.task_desc_6),
            Task(taskTitleId = R.string.task_title_7, taskDescId = R.string.task_desc_7)

        )
    }


}