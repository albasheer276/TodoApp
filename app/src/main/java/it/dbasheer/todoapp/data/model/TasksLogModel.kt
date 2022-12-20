package it.dbasheer.todoapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import it.dbasheer.todoapp.utils.DateUtils.getCurrentDateTimeInMillis

@Entity(
    tableName = "tasks_log",
    foreignKeys = [ForeignKey(
        entity = TaskModel::class,
        parentColumns = ["id"],
        childColumns = ["task_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class TasksLogModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "task_id", index = true) val taskId: Long,
    @ColumnInfo(name = "from_status") val fromStatus: Int,
    @ColumnInfo(name = "to_status") val toStatus: Int,
    val date: Long = getCurrentDateTimeInMillis()
)
