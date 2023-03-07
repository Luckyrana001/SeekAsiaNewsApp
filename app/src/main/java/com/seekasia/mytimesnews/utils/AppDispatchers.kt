package com.seekasia.mytimesnews.utils

import kotlinx.coroutines.CoroutineDispatcher

interface AppDispatchers {
    fun main(): CoroutineDispatcher
    fun default(): CoroutineDispatcher
    fun io(): CoroutineDispatcher
}