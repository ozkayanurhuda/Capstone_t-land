package com.nurozkaya.capstone_t_land.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Users (
    @SerializedName("deger")
    @Expose
    var deger:Int,

    @SerializedName("mail_adres")
    @Expose
    var u_mail:String,

    @SerializedName("sifre")
    @Expose
    var u_sifre:String,

    @SerializedName("ad_soyad")
    @Expose
    var u_fullname:String,

    @SerializedName("telefon")
    @Expose
    var u_tel:String) :Serializable{
}