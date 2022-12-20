package it.dbasheer.todoapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import it.dbasheer.todoapp.data.model.FolderModel
import it.dbasheer.todoapp.data.model.TagModel
import it.dbasheer.todoapp.data.model.TaskModel
import it.dbasheer.todoapp.data.model.TasksLogModel
import it.dbasheer.todoapp.data.room.FolderDao
import it.dbasheer.todoapp.data.room.TagDao
import it.dbasheer.todoapp.data.room.TaskDao
import it.dbasheer.todoapp.data.room.TaskLogDao

@Database(entities = [FolderModel::class, TagModel::class, TaskModel::class, TasksLogModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val folderDao: FolderDao
    abstract val tagDao: TagDao
    abstract val taskDao: TaskDao
    abstract val taskLogDao: TaskLogDao
}