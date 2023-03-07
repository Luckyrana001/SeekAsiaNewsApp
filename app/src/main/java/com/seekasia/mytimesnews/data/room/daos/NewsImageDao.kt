package com.seekasia.mytimesnews.data.room.daos

import androidx.room.Dao
import androidx.room.Query
import com.seekasia.mytimesnews.data.room.models.NewsImageInDb

@Dao
abstract class NewsImageDao : BaseDao<NewsImageInDb>() {

    @Query("DELETE FROM news_image")
    abstract fun deleteAllNewsImages()
}