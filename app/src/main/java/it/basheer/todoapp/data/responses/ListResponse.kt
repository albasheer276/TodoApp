package it.basheer.todoapp.data.responses

data class ListResponse<T>(val data: List<T>) : BaseResponse()
