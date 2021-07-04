package com.nurozkaya.capstone_t_land.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.nurozkaya.capstone_t_land.entity.CRUDCevap
import com.nurozkaya.capstone_t_land.entity.Users
import com.nurozkaya.capstone_t_land.entity.UsersCevap
import com.nurozkaya.capstone_t_land.retrofit.ApiUtils
import com.nurozkaya.capstone_t_land.retrofit.UsersDaoInterface
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class UserdaoRepos {
    private val usersListesi:MutableLiveData<List<Users>> =MutableLiveData()
    private val userDeger: MutableLiveData<Int> = MutableLiveData()
    private val udaoi: UsersDaoInterface = ApiUtils.getUsersDaoInterface()
    private val loggedUser: MutableLiveData<Users> = MutableLiveData()


    fun getUserDeger():MutableLiveData<Int> {
        return userDeger
    }

    fun getUsersListesi():MutableLiveData<List<Users>>{
        return usersListesi
    }

    fun getLoggedUser():MutableLiveData<Users>{
        return loggedUser
    }
//getuser
    fun girisYap(email:String,password:String) {
        udaoi.giris_yap(email,password).enqueue(object : retrofit2.Callback<UsersCevap> {
            override fun onResponse(call: Call<UsersCevap>, response: Response<UsersCevap>) {
                val liste=response.body().users
                usersListesi.value=liste

                val logged=response.body().users[0]
                loggedUser.value=logged

                val deger=response.body().users[0].deger
                userDeger.value=deger

                println("listSize:"+usersListesi.value!!.size)
                println("Fullname:"+usersListesi.value!![0].u_fullname)
                println("userDeger:"+userDeger.value)
            }
            override fun onFailure(call: Call<UsersCevap>?, t: Throwable?) {}
        })
    }

    //add user
    fun uyeOl(email:String, password:String,fullName:String,phone:String) {
        udaoi.uye_ol(email, password, fullName, phone)
            .enqueue(object: retrofit2.Callback<CRUDCevap> {
                override fun onResponse(call: Call<CRUDCevap>?, response: Response<CRUDCevap>) {
                    Log.e("Başarı", response.body().success.toString())
                    Log.e("Mesaj",response.body().message)

                }
                override fun onFailure(call: Call<CRUDCevap>?, t: Throwable?) {} })
    }


}