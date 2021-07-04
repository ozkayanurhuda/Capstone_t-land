package com.nurozkaya.capstone_t_land.viewmodels

import androidx.lifecycle.ViewModel
import com.nurozkaya.capstone_t_land.repo.TisortlerdaoRepos

class UploadTisortViewModel: ViewModel() {
    val tdaor=TisortlerdaoRepos()

    fun uploadTisort(satici_adi:String,name:String,price:String, description:String,img_url:String) {
        tdaor.tisortYukle(satici_adi,name,price,description,img_url)
    }
}