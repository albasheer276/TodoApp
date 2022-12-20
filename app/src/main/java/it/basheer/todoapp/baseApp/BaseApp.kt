package it.basheer.todoapp.baseApp

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class BaseApp : Application(){

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }

}