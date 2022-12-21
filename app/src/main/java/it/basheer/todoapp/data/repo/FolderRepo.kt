package it.basheer.todoapp.data.repo

import it.basheer.todoapp.data.model.FolderModel
import it.basheer.todoapp.data.room.FolderDao
import javax.inject.Inject

class FolderRepo @Inject constructor(private val folderDao: FolderDao) {

    suspend fun createFolder(folderModel: FolderModel) = folderDao.createFolder(folderModel)

    suspend fun updateFolder(folderModel: FolderModel) = folderDao.updateFolder(folderModel)

    suspend fun getFolders() = folderDao.getFolders()

    suspend fun deleteFolder(folderModel: FolderModel) = folderDao.deleteFolder(folderModel)
}