package com.nurozkaya.capstone_t_land.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.nurozkaya.capstone_t_land.R
import com.nurozkaya.capstone_t_land.databinding.FragmentRegisterBinding
import com.nurozkaya.capstone_t_land.viewmodels.RegisterViewModel


class RegisterFragment : Fragment() {

    private lateinit var tasarim:FragmentRegisterBinding
    private val viewModel:RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_register, container, false)

        //kayıt ol
        tasarim.buttonRegisterR.setOnClickListener {
            uploadUserButton(tasarim.editTextEmail.text.toString(), tasarim.editTextPassword.text.toString(),tasarim.editTextUsername.text.toString(),tasarim.editTextPhone.text.toString())

        }

        //signine geç
        tasarim.buttonSigninR.setOnClickListener {
            Log.e("Signin", "clicked")
            val gecis=RegisterFragmentDirections.registerToSignin()
            Navigation.findNavController(it).navigate(gecis)
        }
        return tasarim.root
    }

    //yukarıdan çağır
    fun uploadUserButton(mail:String, password:String,name:String, phone:String) {
        viewModel.uploadUserInfo(mail,password,name,phone)
    }

}