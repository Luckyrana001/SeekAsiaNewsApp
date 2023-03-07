package com.seekasia.mytimesnews.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.seekasia.mytimesnews.data.room.daos.NewsDao
import com.seekasia.mytimesnews.data.room.daos.NewsImageDao
import com.seekasia.mytimesnews.data.room.models.NewsImageInDb
import com.seekasia.mytimesnews.data.room.models.NewsInDb
import com.seekasia.mytimesnews.data.room.utils.DateConverter

@Database(entities = [NewsInDb::class, NewsImageInDb::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class NewsDatabase : RoomDatabase() {

    abstract val newsDao: NewsDao
    abstract val newsImageDao: NewsImageDao

    companion object {
        const val DATABASE_NAME = "news_db"
    }
}