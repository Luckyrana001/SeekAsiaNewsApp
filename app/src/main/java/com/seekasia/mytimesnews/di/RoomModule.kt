package com.seekasia.mytimesnews.di

import android.content.Context
import androidx.room.Room
import com.seekasia.mytimesnews.data.room.NewsDatabase
import com.seekasia.mytimesnews.data.room.NewsDatabase.Companion.DATABASE_NAME
import com.seekasia.mytimesnews.data.room.daos.NewsDao
import com.seekasia.mytimesnews.data.room.daos.NewsImageDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): NewsDatabase {
        return Room.databaseBuilder(context, NewsDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsDao(newsDatabase: NewsDatabase): NewsDao {
        return newsDatabase.newsDao
    }

    @Singleton
    @Provides
    fun provideNewsImageDao(newsDatabase: NewsDatabase): NewsImageDao {
        return newsDatabase.newsImageDao
    }
}