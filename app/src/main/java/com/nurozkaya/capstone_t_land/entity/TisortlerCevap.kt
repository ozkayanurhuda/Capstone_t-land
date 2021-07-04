package com.nurozkaya.capstone_t_land.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.nurozkaya.capstone_t_land.entity.Tisortler

data class TisortlerCevap (
    @SerializedName("tisortler")
    @Expose
    var tisortler:List<Tisortler>,
    @SerializedName("success")
    @Expose
    var success:Int) {

}