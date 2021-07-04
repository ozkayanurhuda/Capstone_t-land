package com.nurozkaya.capstone_t_land.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.nurozkaya.capstone_t_land.entity.CRUDCevap
import com.nurozkaya.capstone_t_land.entity.Tisortler
import com.nurozkaya.capstone_t_land.entity.TisortlerCevap
import com.nurozkaya.capstone_t_land.retrofit.ApiUtils
import com.nurozkaya.capstone_t_land.retrofit.TisortlerDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TisortlerdaoRepos {
    private val tisortList:MutableLiveData<List<Tisortler>> = MutableLiveData()
    private val tdaoi:TisortlerDaoInterface=ApiUtils.getTisortlerDaoInterface()


    fun tisortlerListesi():MutableLiveData<List<Tisortler>> {
        return tisortList
    }

    //satici adına gçre t al
    fun tisortleriAl(satici_adi:String){
        tdaoi.tumTisortler(satici_adi).enqueue(object : Callback<TisortlerCevap> {

            override fun onResponse(call: Call<TisortlerCevap>?, response: Response<TisortlerCevap>) {
                Log.e("Mesaj",response.body().tisortler.toString())
                val t_liste=response.body().tisortler
                tisortList.value=t_liste
            }
            override fun onFailure(call: Call<TisortlerCevap>?, t: Throwable?) {}
        })
    }

    //t yukle
    fun tisortYukle(satici_adi:String,urun_adi:String, urun_fiyat:String,urun_aciklama:String,urun_gorsel_url:String) {
        tdaoi.tisortEkle(satici_adi,urun_adi,urun_fiyat,urun_aciklama,urun_gorsel_url)
            .enqueue(object :Callback<CRUDCevap> {

                override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                    Log.e("Tisort Eklendi", response.body().success.toString())
                    Log.e("Tisort ekleme", response.body().message)
                }
                override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {}
            })
    }

}