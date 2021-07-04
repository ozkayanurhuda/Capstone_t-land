package com.nurozkaya.capstone_t_land

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nurozkaya.capstone_t_land.databinding.ActivitySigninBinding

class SigninActivity :AppCompatActivity(){
    private lateinit var view: ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(view.root)
}}