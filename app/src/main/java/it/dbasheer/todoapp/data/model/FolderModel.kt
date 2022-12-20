package it.dbasheer.todoapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "folder", indices = [Index(value = ["name"], unique = true)])
data class FolderModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    @ColumnInfo(name = "order_num")  val orderNum: Int,
    @ColumnInfo(name = "color_theme") val colorTheme: Int? = null
)
