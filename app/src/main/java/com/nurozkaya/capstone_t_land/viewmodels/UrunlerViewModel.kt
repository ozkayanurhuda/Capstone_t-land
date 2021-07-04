package com.nurozkaya.capstone_t_land.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nurozkaya.capstone_t_land.entity.Tisortler
import com.nurozkaya.capstone_t_land.repo.TisortlerdaoRepos

class UrunlerViewModel:ViewModel() {

    var tisortListesi=MutableLiveData<List<Tisortler>>()
    private val tdaor=TisortlerdaoRepos()

    init{

        tisortleriAl()
        tisortListesi=tdaor.tisortlerListesi()

    }

    fun tisortleriAl() {
        tdaor.tisortleriAl("nurhudaozkaya")
    }


}