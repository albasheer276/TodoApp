package it.basheer.todoapp.data.room

import androidx.room.*
import it.basheer.todoapp.data.model.TagModel

@Dao
interface TagDao {

    /**
     * must be treated by try-catch because abort will return [android.database.sqlite.SQLiteConstraintException]
     */
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun createTag(tagModel: TagModel): Long

    @Update
    suspend fun updateTag(tagModel: TagModel): Int

    @Query("SELECT * FROM tag")
    suspend fun getTags(): List<TagModel>

    @Delete
    suspend fun deleteTag(tagModel: TagModel)
}
