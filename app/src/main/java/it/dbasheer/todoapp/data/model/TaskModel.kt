package it.dbasheer.todoapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import it.dbasheer.todoapp.utils.DateUtils.getCurrentDateTimeInMillis

@Entity(
    tableName = "task",
    foreignKeys = [ForeignKey(
        entity = FolderModel::class,
        parentColumns = ["id"],
        childColumns = ["folder_id"],
        onDelete = ForeignKey.SET_DEFAULT
    ),
        ForeignKey(
            entity = TagModel::class,
            parentColumns = ["id"],
            childColumns = ["tag_id"],
            onDelete = ForeignKey.SET_NULL
        )]
)
data class TaskModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "folder_id", index = true) val folderId: Long = 1,
    @ColumnInfo(name = "tag_id", index = true) val tagId: String? = null,
    val title: String,
    val description: String? = null,
    val status: Int = 0, // 0 => backLog, 1 => to do, 2 => in progress, 3 => completed, 4 => waiting, 5 => canceled
    @ColumnInfo(name = "created_data") val createdData: Long = getCurrentDateTimeInMillis(),
)
