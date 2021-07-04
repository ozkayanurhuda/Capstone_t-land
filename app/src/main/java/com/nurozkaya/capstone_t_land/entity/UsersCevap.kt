package com.nurozkaya.capstone_t_land.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.nurozkaya.capstone_t_land.entity.Users

data class UsersCevap (
    @SerializedName("users")
    @Expose
    var users:List<Users>,
    @SerializedName("success")
    @Expose
    var success:Int ){

}