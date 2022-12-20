package it.dbasheer.todoapp.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import it.dbasheer.todoapp.data.db.AppDatabase
import it.dbasheer.todoapp.utils.DATABASE_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object BaseDataModule {

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

}