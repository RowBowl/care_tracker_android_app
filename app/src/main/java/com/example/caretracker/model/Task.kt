package com.example.caretracker.model

import androidx.annotation.StringRes

data class Task(
    @StringRes val taskTitleId: Int,
    @StringRes val taskDescId: Int
)
