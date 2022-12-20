package it.basheer.todoapp.data.repo

import android.database.sqlite.SQLiteConstraintException
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import it.basheer.todoapp.R
import it.basheer.todoapp.baseApp.BaseApp
import it.basheer.todoapp.data.network.BaseResult
import it.basheer.todoapp.data.responses.BaseResponse
import kotlinx.coroutines.Dispatchers

open class BaseRepo constructor(private val baseApp: BaseApp) {

    open fun<T: BaseResponse> request(
        query: (suspend () -> T)? = null,
        message: String?
    ): LiveData<BaseResult<T>> = liveData(Dispatchers.IO) {
        // send loading status
        emit(BaseResult.loading())

        // run the query first
        if (query != null) {
            try{
                val source = query.invoke()
                emit(BaseResult.success(source, message))
            } catch (ex: SQLiteConstraintException){
                emit(BaseResult.error(baseApp.getString(R.string.data_already_exist)))
            }
        }
    }

}