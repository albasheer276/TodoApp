package it.basheer.todoapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import it.basheer.todoapp.baseApp.BaseApp
import it.basheer.todoapp.data.db.AppDatabase
import it.basheer.todoapp.utils.AppSharedPref
import it.basheer.todoapp.utils.DATABASE_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BaseDataModule {

    @Provides
    fun provideContext(application: BaseApp): Context {
        return application.applicationContext
    }

    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApp {
        return app as BaseApp
    }

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase =
        Room.databaseBuilder(application.applicationContext, AppDatabase::class.java, DATABASE_NAME).build()

    @Provides
    @Singleton
    fun provideFolderDao(appDatabase: AppDatabase) = appDatabase.folderDao

    @Provides
    @Singleton
    fun provideTagDao(appDatabase: AppDatabase) = appDatabase.tagDao

    @Provides
    @Singleton
    fun provideTaskDao(appDatabase: AppDatabase) = appDatabase.taskDao

    @Provides
    @Singleton
    fun provideTaskLogDao(appDatabase: AppDatabase) = appDatabase.taskLogDao

    @Provides
    @Singleton
    fun provideAppSharedPref(application: Application): AppSharedPref =
        AppSharedPref(application.applicationContext)
}