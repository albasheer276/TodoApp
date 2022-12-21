package it.basheer.todoapp.data.repo

import it.basheer.todoapp.data.model.TaskModel
import it.basheer.todoapp.data.room.TaskDao
import javax.inject.Inject

class TaskRepo @Inject constructor(private val taskDao: TaskDao) {

    suspend fun upsertTask(taskModel: TaskModel) = taskDao.upsertTask(taskModel)

    suspend fun getTasks(orderType: String = "date") = taskDao.getTasks(orderType)

    suspend fun getTasksByFolder(folderId: Long, orderType: String = "date") = taskDao.getTasksByFolder(folderId, orderType)

    suspend fun getTasksByTag(tagId: Long, orderType: String = "date") = taskDao.getTasksByTag(tagId, orderType)

    suspend fun deleteTask(taskModel: TaskModel) = taskDao.deleteTask(taskModel)
}