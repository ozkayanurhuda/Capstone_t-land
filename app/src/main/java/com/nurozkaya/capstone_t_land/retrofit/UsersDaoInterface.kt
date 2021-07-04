package com.nurozkaya.capstone_t_land.retrofit

import com.nurozkaya.capstone_t_land.entity.CRUDCevap
import com.nurozkaya.capstone_t_land.entity.UsersCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UsersDaoInterface {

//-----------------------ÜYE OL
    @POST("uye_ol.php")
    @FormUrlEncoded
    fun uye_ol(
        @Field("mail_adres") mail_adres:String,
        @Field("sifre") sifre:String,
        @Field("ad_soyad") ad_soyad:String,
        @Field("telefon") telefon:String) : Call<CRUDCevap>
    //cud mu user mı cevap

//-----------------------GİRİŞ YAP
    @POST("giris_yap.php")
    @FormUrlEncoded
    fun giris_yap(
        @Field("mail_adres") mail_adres: String,
        @Field("sifre") sifre: String) : Call<UsersCevap>


}