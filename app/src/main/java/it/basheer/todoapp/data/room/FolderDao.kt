package it.basheer.todoapp.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import it.basheer.todoapp.data.model.FolderModel

@Dao
interface FolderDao {

    /**
     * must be treated by try-catch because abort will return [android.database.sqlite.SQLiteConstraintException]
     */
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun createFolder(folderModel: FolderModel): Long

    @Update
    suspend fun updateFolder(folderModel: FolderModel): Int

    @Query("SELECT * FROM folder ORDER BY order_num ASC")
    suspend fun getFolders(): List<FolderModel>

    @Delete
    suspend fun deleteFolder(folderModel: FolderModel)
}