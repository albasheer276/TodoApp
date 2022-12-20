package it.basheer.todoapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import it.basheer.todoapp.data.model.FolderModel
import it.basheer.todoapp.data.model.TagModel
import it.basheer.todoapp.data.model.TaskModel
import it.basheer.todoapp.data.model.TasksLogModel
import it.basheer.todoapp.data.room.FolderDao
import it.basheer.todoapp.data.room.TagDao
import it.basheer.todoapp.data.room.TaskDao
import it.basheer.todoapp.data.room.TaskLogDao

@Database(entities = [FolderModel::class, TagModel::class, TaskModel::class, TasksLogModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val folderDao: FolderDao
    abstract val tagDao: TagDao
    abstract val taskDao: TaskDao
    abstract val taskLogDao: TaskLogDao
}