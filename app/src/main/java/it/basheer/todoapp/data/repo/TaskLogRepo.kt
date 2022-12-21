package it.basheer.todoapp.data.repo

import it.basheer.todoapp.data.model.TasksLogModel
import it.basheer.todoapp.data.room.TaskLogDao
import javax.inject.Inject

class TaskLogRepo @Inject constructor(private val taskLogDao: TaskLogDao) {

    suspend fun insertTaskLog(taskLogModel: TasksLogModel) = taskLogDao.insertTaskLog(taskLogModel)

    suspend fun getTasksLogs() = taskLogDao.getTasksLogs()

    suspend fun getTaskLogs(taskId: Long) = taskLogDao.getTaskLogs(taskId)
}