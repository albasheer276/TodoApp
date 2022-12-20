package it.basheer.todoapp.utils

import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneOffset

object DateUtils {

    fun getCurrentDateTimeInMillis() = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)

    fun convertMillisToDateTime(nowInSeconds: Long) = LocalDateTime.ofEpochSecond(nowInSeconds, 0, ZoneOffset.UTC)

}