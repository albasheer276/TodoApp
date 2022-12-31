package it.basheer.todoapp.utils

import android.content.Context
import android.content.res.Configuration
import java.util.*

object ConfigurationChanger {

    /**
     * Override locale.
     *
     * update locale to Arabic language
     * @param context Context
     */
    fun overrideLocale(context: Context?, lang: String): Context? {
        val locale = Locale(lang)
        val newConfig = Configuration()
        newConfig.setLocale(locale)
        newConfig.setLayoutDirection(locale)
        return context?.createConfigurationContext(newConfig)
    }
}