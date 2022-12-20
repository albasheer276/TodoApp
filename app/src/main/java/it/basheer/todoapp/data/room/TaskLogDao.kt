package it.basheer.todoapp.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import it.basheer.todoapp.data.model.TasksLogModel

@Dao
interface TaskLogDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTaskLog(tasksLogModel: TasksLogModel): Long

    @Query("SELECT * FROM tasks_log order by date DESC")
    suspend fun getTasksLogs(): List<TasksLogModel>

    @Query("SELECT * FROM tasks_log where task_id = :taskId order by date DESC")
    suspend fun getTaskLogs(taskId: Long): List<TasksLogModel>
}