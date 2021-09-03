package com.jc.deliverhealth.model

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StarWarsRepository {
    companion object{
        private const val BASE_URL = "https://duet-public-content.s3.us-east-2.amazonaws.com/"
        private const val NEWS_DELAY = 0L
    }
    private val starWarsService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(StarWarsService::class.java)

    fun getStarWars(): Flow<Result> {
        return flow {
            var startWarsSource = starWarsService.getStarWars()
            startWarsSource.results?.forEach {
                emit(it)
                delay(NEWS_DELAY)
            }
        }
    }
}