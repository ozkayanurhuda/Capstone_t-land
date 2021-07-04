package com.nurozkaya.capstone_t_land.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nurozkaya.capstone_t_land.entity.Users
import com.nurozkaya.capstone_t_land.repo.UserdaoRepos

class SigninViewModel:ViewModel() {
    val udaor=UserdaoRepos()
    var loggedUser=MutableLiveData<Users>()
    var userDeger=MutableLiveData<Int>()

    init {
        loggedUser=udaor.getLoggedUser()
        userDeger=udaor.getUserDeger()
    }

    fun userDegerAl():MutableLiveData<Int> {
        return userDeger
    }

    fun kullaniciAl():MutableLiveData<Users>{
        return loggedUser
    }

    fun signin(mail:String,password:String) {
        udaor.girisYap(mail,password)
    }
}