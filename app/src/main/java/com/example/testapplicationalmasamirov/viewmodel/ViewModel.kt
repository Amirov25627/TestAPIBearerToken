package com.example.testapplicationalmasamirov.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testapplicationalmasamirov.network.ApiClient
import com.example.testapplicationalmasamirov.network.PostsResponse
import com.example.testapplicationalmasamirov.network.TokenManager

open class ViewModel(app: Application) : ViewModel() {
    val mailIncorrect = MutableLiveData<Boolean>()
    val emptyText = MutableLiveData<Boolean>()
    val resultScreen = MutableLiveData<Boolean>()
    val postData = MutableLiveData<PostsResponse>()



    //checking email & password
    fun entering(mail: String, password: String) {
        mailIncorrect.value = false
        emptyText.value = false
        resultScreen.value = false
        if (mail != "" && password != "") {
            var x = 0
            for (i in 1 until mail.length) {
                if (mail[i] == '@') {
                    x++
                }
            }
            if (x != 0) {
                resultScreen.value = true
            } else {
                mailIncorrect.value = true
            }
        } else {
            emptyText.value = true
        }

    }








}
