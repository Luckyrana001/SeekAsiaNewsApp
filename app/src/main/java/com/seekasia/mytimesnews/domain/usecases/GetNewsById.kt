package com.seekasia.mytimesnews.domain.usecases

import com.seekasia.mytimesnews.domain.models.News
import com.seekasia.mytimesnews.domain.repositories.NewsRepository
import com.seekasia.mytimesnews.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNewsById @Inject constructor(val newsRepository: NewsRepository) {

    suspend operator fun invoke(id: Long): Flow<DataState<News?>> {
        return newsRepository.getNewsById(id)
    }

}