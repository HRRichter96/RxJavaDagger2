package com.dynamicdevs.rxjavadagger2.model

import com.dynamicdevs.rxjavadagger2.model.data.GitResponse
import com.dynamicdevs.rxjavadagger2.model.data.GitResponseItem
import com.dynamicdevs.rxjavadagger2.network.GitRetrofit
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitRepository @Inject constructor(private val gitRetrofit: GitRetrofit) {
    //Reading from online repo
    fun readFromRemoteSource(): Single<List<GitResponseItem>> = gitRetrofit.getCharactersRemote()


}