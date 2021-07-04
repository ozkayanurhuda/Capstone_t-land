package com.nurozkaya.capstone_t_land.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.nurozkaya.capstone_t_land.MainActivity
import com.nurozkaya.capstone_t_land.R
import com.nurozkaya.capstone_t_land.databinding.FragmentUserBinding
import com.nurozkaya.capstone_t_land.viewmodels.SigninViewModel


class UserFragment : Fragment() {

    private lateinit var tasarim:FragmentUserBinding
    private val viewModel:SigninViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_user, container, false)
        tasarim.userFragment=this

        viewModel.loggedUser.observe(viewLifecycleOwner, {
            tasarim.userObj=it
        })


        return tasarim.root
    }


}