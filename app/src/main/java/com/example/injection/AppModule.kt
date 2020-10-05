package com.example.injection

import android.content.Context
import com.example.model.RestAPI
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import javax.inject.Singleton

const val BASE_URL = "http://api.icndb.com/"

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun getContextMod() = context

    @Provides
    @Singleton
    fun getRestApi(retrofit: Retrofit): RestAPI {
        return retrofit.create(RestAPI::class.java)
    }

    @Provides
    @Singleton
    fun getRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun getGson(): Gson {
        return GsonBuilder()
            .create()

    }
}