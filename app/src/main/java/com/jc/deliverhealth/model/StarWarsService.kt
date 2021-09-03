package com.jc.deliverhealth.model

import retrofit2.http.GET

interface StarWarsService {
    @GET("project.json ")
    suspend fun getStarWars():StarWars
}