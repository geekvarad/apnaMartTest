package com.example.myapplication.utility

import com.example.myapplication.data.api.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Utils {
    companion object{
        private val bu :String="https://api.github.com/"
        private var retrofit : Api? = null
        fun getRetrofitInstance() : Api{
            if (retrofit ==null){
                retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(bu)
                    .build()
                    .create(Api::class.java)

            }
            return retrofit!!

        }
    }


}