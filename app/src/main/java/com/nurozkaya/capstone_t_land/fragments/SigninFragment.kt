package com.nurozkaya.capstone_t_land.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.nurozkaya.capstone_t_land.MainActivity
import com.nurozkaya.capstone_t_land.R
import com.nurozkaya.capstone_t_land.databinding.FragmentSigninBinding
import com.nurozkaya.capstone_t_land.viewmodels.SigninViewModel

class SigninFragment :Fragment(){
   private lateinit var tasarim:FragmentSigninBinding
   private val viewModel:SigninViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        tasarim= DataBindingUtil.inflate(inflater, R.layout.fragment_signin, container, false)
        tasarim.signinFragment=this

        //t_ekle ekraına gecis
        tasarim.imageView.setOnClickListener {
            Log.e("Add Tisort","clicked")
            val gecis=SigninFragmentDirections.signinToUpload()
            Navigation.findNavController(it).navigate(gecis)
        }


        //kayıtola tıklarsa
        tasarim.buttonRegisterS.setOnClickListener {
            val gecis=SigninFragmentDirections.registeraGecis()
            Navigation.findNavController(it).navigate(gecis)
        }

        //hesabı varsa urunlere gec anasayfa
        tasarim.buttonSigninS.setOnClickListener {
            viewModel.signin(tasarim.editTextEmail.text.toString(), tasarim.editTextPassword.text.toString())
            viewModel.loggedUser.observe(viewLifecycleOwner, {
                val currentUser=it
                println("gelenuser"+currentUser.toString())
                val userDeger=it.deger

                println("User Deger" +userDeger)

                if(userDeger==1) {
                    val intent= Intent(requireContext(),MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(requireContext(),"No user ", Toast.LENGTH_LONG).show()
                }
            })


        }


        return tasarim.root
    }


}