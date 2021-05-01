package com.KotlinTest.omaraDev.Repository.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.KotlinTest.omaraDev.model.Posts
import com.KotlinTest.omaraDev.network.APIS
import retrofit2.Response
import javax.inject.Inject
import javax.security.auth.callback.Callback


class MainRepo  {
    private var listOfPosts : MutableLiveData<List<Posts>> = MutableLiveData()
    private var apis : APIS

    @Inject
    constructor(apis: APIS) : super() {
        this.apis = apis
    }
    
    public fun getPosts() : MutableLiveData<List<Posts>>{
        apis.getPosts().enqueue(object : Callback, retrofit2.Callback<List<Posts>> {
            override fun onResponse(
                call: retrofit2.Call<List<Posts>>,
                response: Response<List<Posts>>
            ) {
                listOfPosts.value = response.body()
            }

            override fun onFailure(call: retrofit2.Call<List<Posts>>, t: Throwable) {
                Log.d(TAG, "onFailure: "+t.message)
            }

        })
        
        return listOfPosts;
    }

    companion object {
        private const val TAG = "MainRepo"
    }
}