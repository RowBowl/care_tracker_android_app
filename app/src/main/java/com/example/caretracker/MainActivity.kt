package com.example.caretracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caretracker.data.Datasource
import com.example.caretracker.model.Task
import com.example.caretracker.ui.theme.CareTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CareTrackerTheme (darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CareTrackerApp()
                }
            }
        }
    }
}

@Composable
@Preview
fun CareTrackerPreview() {
    CareTrackerApp()
}

@Composable
fun CareTrackerApp() {
    val taskList = Datasource().generateTasks()

    TaskList(taskList, modifier = Modifier.padding(24.dp))
    //TrackedItem(taskList[0])
}

@Composable
fun TaskList(taskList: List<Task>, modifier: Modifier = Modifier) {

    LazyColumn(modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)) {
        items(taskList) {task ->
            TrackedItem(task = task)
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackedItem(
    task: Task,
    isExpanded: MutableState<Boolean> = remember { mutableStateOf(false) },
    modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        onClick = {isExpanded.value = !isExpanded.value}
    ) {
        Column (
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = stringResource(task.taskTitleId),
                fontWeight = FontWeight.ExtraBold,
                style = MaterialTheme.typography.headlineMedium)
            AnimatedVisibility(visible = isExpanded.value) {
                Text(
                    text = stringResource(task.taskDescId),
                    fontWeight = FontWeight.Light,
                    style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
