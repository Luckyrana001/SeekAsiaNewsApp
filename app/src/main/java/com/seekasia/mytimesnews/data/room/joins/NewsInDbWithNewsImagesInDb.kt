package com.seekasia.mytimesnews.data.room.joins

import androidx.room.Embedded
import androidx.room.Relation
import com.seekasia.mytimesnews.data.room.models.NewsImageInDb
import com.seekasia.mytimesnews.data.room.models.NewsInDb

data class NewsInDbWithNewsImagesInDb(
    @Embedded
    val newsInDb: NewsInDb,
    @Relation(parentColumn = "id", entityColumn = "news_id")
    val newsImageInDb: List<NewsImageInDb>
)