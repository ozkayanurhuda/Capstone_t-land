package com.nurozkaya.capstone_t_land.retrofit

class ApiUtils {
    companion object{
        val BASE_URL = "http://upschool.canerture.com/"

        fun getTisortlerDaoInterface(): TisortlerDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(TisortlerDaoInterface::class.java)
        }

        fun getUsersDaoInterface(): UsersDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(UsersDaoInterface::class.java)
        }
    }
}