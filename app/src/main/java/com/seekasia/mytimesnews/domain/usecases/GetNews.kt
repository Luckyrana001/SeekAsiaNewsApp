package com.seekasia.mytimesnews.domain.usecases

import com.seekasia.mytimesnews.domain.models.News
import com.seekasia.mytimesnews.domain.models.OrderBy
import com.seekasia.mytimesnews.domain.repositories.NewsRepository
import com.seekasia.mytimesnews.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNews @Inject constructor(val newsRepository: NewsRepository) {

    operator fun invoke(query: String?, orderBy: OrderBy): Flow<DataState<Flow<List<News>>>> {
        return newsRepository.getNews(query, orderBy)
    }

}