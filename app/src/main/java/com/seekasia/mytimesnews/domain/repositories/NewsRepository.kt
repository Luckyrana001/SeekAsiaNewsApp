package com.seekasia.mytimesnews.domain.repositories

import com.seekasia.mytimesnews.domain.models.News
import com.seekasia.mytimesnews.domain.models.OrderBy
import com.seekasia.mytimesnews.utils.DataState
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(query: String?, orderBy: OrderBy): Flow<DataState<Flow<List<News>>>>

    suspend fun getNewsById(id: Long): Flow<DataState<News?>>

    suspend fun createNews(news: News): Flow<DataState<News>>
}