package com.KotlinTest.omaraDev.network

import com.KotlinTest.omaraDev.model.Posts
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface APIS {
    @GET("posts")
    fun getPosts(): Observable<List<Posts>>
    //CallBack
    /*
     fun getPosts() : Call<List<Posts>>
     */
}