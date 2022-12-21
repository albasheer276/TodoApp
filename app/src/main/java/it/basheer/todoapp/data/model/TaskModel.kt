package it.basheer.todoapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.PrimaryKey
import it.basheer.todoapp.utils.DateUtils.getCurrentDateTimeInMillis

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
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "folder_id", index = true) var folderId: Long = 1,
    @ColumnInfo(name = "tag_id", index = true) var tagId: String? = null,
    var title: String,
    var description: String? = null,
    var status: Int = 0, // 0 => backLog, 1 => to do, 2 => in progress, 3 => completed, 4 => waiting, 5 => canceled
    @ColumnInfo(name = "created_data") var createdData: Long = getCurrentDateTimeInMillis(),
) {
    @Ignore
    var folder: FolderModel? = null

    @Ignore
    var tags: List<TagModel>? = null
}
