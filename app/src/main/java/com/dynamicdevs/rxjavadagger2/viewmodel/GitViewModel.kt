package com.dynamicdevs.rxjavadagger2.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dynamicdevs.rxjavadagger2.model.data.GitResponse
import com.dynamicdevs.rxjavadagger2.model.data.GitResponseItem
import com.dynamicdevs.rxjavadagger2.network.GitRetrofit
import com.dynamicdevs.rxjavadagger2.util.GitSingleton.Companion.gitComponent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call

import retrofit2.Callback
import retrofit2.Response

class GitViewModel: ViewModel() {

    val gitData = MutableLiveData<List<GitResponseItem>>()
    private val compDisposable = CompositeDisposable()

    init {
        compDisposable.add(
            gitComponent.getRepository().readFromRemoteSource()
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    Log.d("TAG_X", "update LiveData on ${Thread.currentThread().name}")
                    gitData.postValue(it)
                    clearDisposable()
                },  {throwable ->
//                    Log.d("TAG_X", " ${}")
                    Log.d("TAG_X", "Oops: failed ViewModel ${throwable.localizedMessage}")
                })
        )
    }

    private fun clearDisposable() {
        compDisposable.clear()
    }

    override fun onCleared() {
        clearDisposable()
        super.onCleared()

    }
}
