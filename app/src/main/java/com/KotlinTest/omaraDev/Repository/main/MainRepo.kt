package com.KotlinTest.omaraDev.Repository.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.KotlinTest.omaraDev.model.Posts
import com.KotlinTest.omaraDev.network.APIS
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers

import javax.inject.Inject

import io.reactivex.disposables.Disposable

import io.reactivex.schedulers.Schedulers


class MainRepo {
    private var listOfPosts: MutableLiveData<List<Posts>> = MutableLiveData()
    private var apis: APIS

    @Inject
    constructor(apis: APIS) : super() {
        this.apis = apis
    }

     fun getPosts(): MutableLiveData<List<Posts>> {

        //RxKotlin
        apis.getPosts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<List<Posts>> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: List<Posts>) {
                    val list: List<Posts>? = t
                    listOfPosts.value = list
                }

                override fun onError(e: Throwable) {
                    Log.d(Companion.TAG, "onError: " +e)
                }
            })

        return listOfPosts;

    }
    //CallBack
    /* apis.getPosts().enqueue(object : Callback, retrofit2.Callback<List<Posts>> {
         override fun onResponse(
             call: retrofit2.Call<List<Posts>>,
             response: Response<List<Posts>>
         ) {
             listOfPosts.value = response.body()
         }

         override fun onFailure(call: retrofit2.Call<List<Posts>>, t: Throwable) {
             Log.d(TAG, "onFailure: "+t.message)
         }

     })*/

    companion object {
        private const val TAG = "MainRepo"
    }
}

