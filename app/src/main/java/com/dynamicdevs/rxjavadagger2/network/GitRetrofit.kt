package com.dynamicdevs.rxjavadagger2.network

import com.dynamicdevs.rxjavadagger2.model.data.GitResponse
import com.dynamicdevs.rxjavadagger2.model.data.GitResponseItem
import com.dynamicdevs.rxjavadagger2.util.Constants.Companion.BASE_URL
import com.dynamicdevs.rxjavadagger2.util.Constants.Companion.END_POINT
import com.dynamicdevs.rxjavadagger2.util.Constants.Companion.USER_PATH
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitRetrofit @Inject constructor() {

    private val client = OkHttpClient
        .Builder()
        .build()

    private val gitService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(client)
        .build()
        .create(GitService::class.java)

    fun getCharactersRemote() = gitService.getAllCharacters(USER_PATH)

    interface GitService {
        @GET(END_POINT)
        fun getAllCharacters(@Path(USER_PATH) name: String): Single<List<GitResponseItem>>
    }
}