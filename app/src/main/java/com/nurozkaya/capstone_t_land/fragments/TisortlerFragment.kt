package com.nurozkaya.capstone_t_land.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.nurozkaya.capstone_t_land.MainActivity
import com.nurozkaya.capstone_t_land.R
import com.nurozkaya.capstone_t_land.adapter.UrunlerAdapter
import com.nurozkaya.capstone_t_land.databinding.FragmentTisortlerBinding
import com.nurozkaya.capstone_t_land.viewmodels.UrunlerViewModel

class TisortlerFragment : Fragment(){
    private lateinit var tasarim:FragmentTisortlerBinding
    private lateinit var adapter:UrunlerAdapter
    private val viewModel:UrunlerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        tasarim= DataBindingUtil.inflate(inflater, R.layout.fragment_tisortler, container, false)
        tasarim.tisortlerFragment = this

        //observe the data
        viewModel.tisortListesi.observe(viewLifecycleOwner, {
            adapter= UrunlerAdapter(requireContext(),it, viewModel)
            tasarim.adapter=adapter
        })

        return tasarim.root
    }




}