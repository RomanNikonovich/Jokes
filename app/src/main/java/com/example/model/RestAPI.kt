package com.example.model

import com.example.model.entity.JokesList
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface RestAPI {
    @GET("jokes/random/{count}")
    fun loadJokes(
        @Path("count") count: String,
    ): Observable<JokesList>
}