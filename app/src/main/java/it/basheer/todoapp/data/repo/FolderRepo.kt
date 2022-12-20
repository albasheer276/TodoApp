package it.basheer.todoapp.data.repo

import it.basheer.todoapp.R
import it.basheer.todoapp.baseApp.BaseApp
import it.basheer.todoapp.data.model.FolderModel
import it.basheer.todoapp.data.responses.ListResponse
import it.basheer.todoapp.data.responses.SingleResponse
import it.basheer.todoapp.data.responses.UnitResponse
import it.basheer.todoapp.data.room.FolderDao
import javax.inject.Inject

class FolderRepo @Inject constructor(private val baseApp: BaseApp, private val folderDao: FolderDao) : BaseRepo(baseApp) {

    suspend fun createFolder(folderModel: FolderModel) = request(
        query = { SingleResponse(folderDao.createFolder(folderModel)) },
        message = baseApp.getString(R.string.insert_folder)
    )

    suspend fun updateFolder(folderModel: FolderModel) = request(
        query = { SingleResponse(folderDao.updateFolder(folderModel)) },
        message = baseApp.getString(R.string.update_folder)
    )

    suspend fun getFolders() = request(
        query = { ListResponse(folderDao.getFolders()) },
        message = baseApp.getString(R.string.get_folders)
    )

    suspend fun deleteFolder(folderModel: FolderModel) = request(
        query = { UnitResponse(folderDao.deleteFolder(folderModel)) },
        message = baseApp.getString(R.string.delete_folder)
    )
}