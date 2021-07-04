package com.nurozkaya.capstone_t_land.retrofit

import com.nurozkaya.capstone_t_land.entity.CRUDCevap
import com.nurozkaya.capstone_t_land.entity.TisortlerCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface TisortlerDaoInterface {

//--------------kisi adına göre ürünleri çek
    @POST("urunler.php")
    @FormUrlEncoded
    fun tumTisortler (
        @Field("satici_adi") satici_adi:String) : Call<TisortlerCevap>

//--------------------------insert
    @POST("urun_ekle.php")
    @FormUrlEncoded
    fun tisortEkle(
        @Field("satici_adi") satici_adi: String,
        @Field("urun_adi") urun_adi:String,
        @Field("urun_fiyat") urun_fiyat:String,
        @Field("urun_aciklama") urun_aciklama:String,
        @Field("urun_gorsel_url") urun_gorsel_url:String ) : Call<CRUDCevap>

//---------------------------sepet guncelle
//    @POST("sepet_durum_degistir.php")
//    @FormUrlEncoded
//    fun sepetDurumDegistir(
//    @Field("id") id:Int)
//    @Field("sepet_durum") sepet_durum:Int)
//    : Call<CRUDCevap>


//    @POST("indirimli_urun_durum_degistir.php")
//    @FormUrlEncoded
//    fun indirimDurumDegistir(
//        @Field("id") id:Int,
//        @Field("urun_indirimli_mi") urun_indirimli_mi:Int
//    ): Call<CRUDCevap>

}