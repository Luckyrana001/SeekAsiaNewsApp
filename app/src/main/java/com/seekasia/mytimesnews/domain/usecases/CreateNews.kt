package com.seekasia.mytimesnews.domain.usecases

import com.seekasia.mytimesnews.domain.models.News
import com.seekasia.mytimesnews.domain.models.NewsImage
import com.seekasia.mytimesnews.domain.repositories.NewsRepository
import com.seekasia.mytimesnews.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*
import javax.inject.Inject

class CreateNews @Inject constructor(val newsRepository: NewsRepository) {

    suspend operator fun invoke(
        title: String,
        newsAbstract: String,
        publishDate: Date,
        category: String,
        author: String,
        source: String, url: String,
        images: List<NewsImage>
    ): Flow<DataState<News?>> {
        arrayOf(title, newsAbstract, category, author, source, url).forEach {
            if (it.isBlank()) {
                return flow {
                    emit(DataState.Failure(Exception("Some provided fields are blank")))
                }
            }
        }

        return newsRepository.createNews(
            News(
                0,
                title,
                newsAbstract,
                publishDate,
                category,
                author,
                source,
                url,
                images
            )
        )
    }

}