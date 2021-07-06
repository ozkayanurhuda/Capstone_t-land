package com.nurozkaya.capstone_t_land.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.nurozkaya.capstone_t_land.R
import com.nurozkaya.capstone_t_land.databinding.FragmentUploadTisortBinding
import com.nurozkaya.capstone_t_land.viewmodels.UploadTisortViewModel
import kotlinx.android.synthetic.main.fragment_upload_tisort.*


class UploadTisortFragment : Fragment() {
    private lateinit var tasarim:FragmentUploadTisortBinding
    private val viewModel:UploadTisortViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_upload_tisort, container, false)

        tasarim.uploadTisortFragment=this
        //uploadTisortFragment.tisortEkleB(saticiAdiText.getText().toString(),tisortAdiText.getText().toString(),fiyatText.getText().toString(),aciklamaText.getText().toString(),imgUrlText.getText().toString())}"

        tasarim.toolbarUploadTisort.title=""

        tasarim.tisortEkleButton.setOnClickListener {
            uploadTisortButton(saticiAdiText.getText().toString(),tisortAdiText.getText().toString(),fiyatText.getText().toString(),aciklamaText.getText().toString(),imgUrlText.getText().toString())
        }
        return tasarim.root
    }

    fun uploadTisortButton(satici_adi:String,name:String, price:String, description:String, img_url:String) {
        viewModel.uploadTisort(satici_adi,name,price,description,img_url)
    }



}