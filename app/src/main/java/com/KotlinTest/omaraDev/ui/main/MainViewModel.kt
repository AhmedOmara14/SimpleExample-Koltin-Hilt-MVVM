package com.KotlinTest.omaraDev.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.KotlinTest.omaraDev.Repository.main.MainRepo
import com.KotlinTest.omaraDev.model.Posts


class MainViewModel : ViewModel {
    var mainRepo: MainRepo

    @ViewModelInject
    constructor(mainRepo: MainRepo) : super() {
        this.mainRepo = mainRepo
    }

    public fun getPosts(): MutableLiveData<List<Posts>> {
        return mainRepo.getPosts()
    }
}