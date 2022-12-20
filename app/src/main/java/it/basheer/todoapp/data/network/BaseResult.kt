package it.basheer.todoapp.data.network

data class BaseResult<out T>(
    val static: BaseStatus,
    val data: T?,
    val messages: String?
) {
    enum class BaseStatus {
        LOADING,
        SUCCESS,
        ERROR
    }

    companion object {
        fun <T> loading(): BaseResult<T> {
            return BaseResult(BaseStatus.LOADING, null, null)
        }

        fun <T> success(data: T, message: String?): BaseResult<T> {
            return BaseResult(BaseStatus.SUCCESS, data, message)
        }

        fun <T> error(message: String?): BaseResult<T> {
            return BaseResult(BaseStatus.ERROR, null, message)
        }
    }
}
