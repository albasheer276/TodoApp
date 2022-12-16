package it.dbasheer.todoapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import it.dbasheer.todoapp.utils.DateUtils.getCurrentDateTimeInMillis

@Entity(tableName = "task")
data class TaskModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String? = null,
    val status: Int = 0, // 0 => backLog, 1 => to do, 2 => in progress, 3 => completed, 4 => waiting, 5 => canceled
    @ColumnInfo(name = "created_data") val createdData: Long = getCurrentDateTimeInMillis(),
)
