package it.basheer.todoapp.data.room

import androidx.room.*
import it.basheer.todoapp.data.model.TaskModel

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertTask(taskModel: TaskModel): Long

    /**
     * orderType => date, title
     */
    @Query(
        "SELECT * FROM task order by " +
                "case :orderType when('date') then created_data end DESC, " +
                "case :orderType when('title') then title end ASC"
    )
    suspend fun getTasks(orderType: String): List<TaskModel>

    /**
     * orderType => date, title
     */
    @Query(
        "SELECT * FROM task where folder_id = :folderId order by " +
                "case :orderType when('date') then created_data end DESC, " +
                "case :orderType when('title') then title end ASC"
    )
    suspend fun getTasksByFolder(folderId: Long, orderType: String): List<TaskModel>

    /**
     * should add '%tagId%'
     */
    @Query(
        "SELECT * FROM task where tag_id LIKE :tagId order by " +
                "case :orderType when('date') then created_data end DESC, " +
                "case :orderType when('title') then title end ASC"
    )
    suspend fun getTasksByTag(tagId: Long, orderType: String): List<TaskModel>

    @Delete
    suspend fun deleteTask(taskModel: TaskModel)
}