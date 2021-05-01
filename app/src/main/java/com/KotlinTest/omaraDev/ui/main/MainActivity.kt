package com.KotlinTest.omaraDev.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.KotlinTest.omaraDev.R
import dagger.hilt.android.AndroidEntryPoint

 /**
  Created By Ahmed Omara
 **/
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPosts()

    }

    private fun getPosts() {
        mainViewModel.getPosts(
        ).observe(this, Observer { it ->
            for (i in it) {
                Log.d(TAG, "getPosts: "+i.title)
            }
        })

    }

    companion object {
        private const val TAG = "MainActivity"
    }
}