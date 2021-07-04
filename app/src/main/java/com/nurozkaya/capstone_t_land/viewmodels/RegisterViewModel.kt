package com.nurozkaya.capstone_t_land.viewmodels

import androidx.lifecycle.ViewModel
import com.nurozkaya.capstone_t_land.repo.UserdaoRepos

class RegisterViewModel:ViewModel() {
    val udaor=UserdaoRepos()

    fun uploadUserInfo(mail:String, password:String,name:String,phone:String) {
        udaor.uyeOl(mail,password,name, phone)
    }
}