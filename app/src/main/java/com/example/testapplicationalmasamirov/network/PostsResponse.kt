package com.example.testapplicationalmasamirov.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PostsResponse(
    @SerializedName("id")
    var id: String,

    @SerializedName("name")
    var name: String,

    @SerializedName("email")
    var e_mail: String,

    @SerializedName("phone")
    var phone: String,
//
//    @SerializedName("avatar")
//    var avatar: String,
//
    @SerializedName("position")
    var position: String,
//
//    @SerializedName("company_name")
//    var company_name: String,
//
//    @SerializedName("name_eng")
//    var name_eng: String,
//
    @SerializedName("timezone")
    var timezone: String
//
//    @SerializedName("sections")
//    var sections: String,
//
//    @SerializedName("alert_email")
//    var alert_email: String,
//
//    @SerializedName("send_system_notifications")
//    var notifications: Boolean
) : Serializable

