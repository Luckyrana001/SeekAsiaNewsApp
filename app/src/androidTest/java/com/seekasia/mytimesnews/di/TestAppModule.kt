package com.seekasia.mytimesnews.di

import android.content.Context
import com.seekasia.mytimesnews.data.repositories.NewsRepositoryImpl
import com.seekasia.mytimesnews.data.retrofit.NyTimesApi
import com.seekasia.mytimesnews.data.retrofit.RetrofitNewsMapper
import com.seekasia.mytimesnews.data.room.RoomNewsMapper
import com.seekasia.mytimesnews.data.room.daos.NewsDao
import com.seekasia.mytimesnews.data.room.daos.NewsImageDao
import com.seekasia.mytimesnews.domain.repositories.NewsRepository
import com.seekasia.mytimesnews.utils.AppDispatchers
import com.seekasia.mytimesnews.utils.isConnectedToInternet
import com.seekasia.mytimesnews.di.AppModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher

@ExperimentalCoroutinesApi
@TestInstallIn(components = [SingletonComponent::class], replaces = [AppModule::class])
@Module
object TestAppModule {

    @Provides
    fun provideContext(): Context {
        val context = mockk<Context>(relaxed = true)
        every { context.getString(any()) } returns "Some Error Message"
        every { context.isConnectedToInternet() } returns true
        return context
    }

    @Provides
    fun provideDispatchers(): AppDispatchers {
        return object : AppDispatchers {
            override fun main(): CoroutineDispatcher {
                return TestCoroutineDispatcher()
            }

            override fun default(): CoroutineDispatcher {
                return TestCoroutineDispatcher()
            }

            override fun io(): CoroutineDispatcher {
                return TestCoroutineDispatcher()
            }

        }
    }


    @ExperimentalCoroutinesApi
    @Provides
    fun provideNewsRepository(
        retrofitNewsMapper: RetrofitNewsMapper, nyTimesApi: NyTimesApi,
        roomNewsMapper: RoomNewsMapper,
        newsDao: NewsDao, newsImageDao: NewsImageDao,
        appDispatchers: AppDispatchers, context: Context
    ): NewsRepository {
        return NewsRepositoryImpl(
            retrofitNewsMapper,
            nyTimesApi,
            roomNewsMapper,
            newsDao,
            newsImageDao,
            appDispatchers,
            context
        )
    }
}