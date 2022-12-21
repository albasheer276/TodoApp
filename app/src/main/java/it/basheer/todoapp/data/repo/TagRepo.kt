package it.basheer.todoapp.data.repo

import it.basheer.todoapp.data.model.TagModel
import it.basheer.todoapp.data.room.TagDao
import javax.inject.Inject

class TagRepo @Inject constructor(private val tagDao: TagDao) {

    suspend fun createTag(tagModel: TagModel) = tagDao.createTag(tagModel)

    suspend fun updateTag(tagModel: TagModel) = tagDao.updateTag(tagModel)

    suspend fun getTags() = tagDao.getTags()

    suspend fun deleteTag(tagModel: TagModel) = tagDao.deleteTag(tagModel)
}