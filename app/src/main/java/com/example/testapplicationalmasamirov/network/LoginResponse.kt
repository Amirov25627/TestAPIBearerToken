package com.example.testapplicationalmasamirov.network

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("token")
    var authToken: String
)