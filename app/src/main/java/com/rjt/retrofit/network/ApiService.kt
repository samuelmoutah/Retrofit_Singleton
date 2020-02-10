package com.rjt.retrofit.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

//class ApiService {
//
//    companion object {
//
//        private const val BASE_URL = "https://api.myjson.com/bins/"
//
//
//        fun getClient() : Retrofit {
//            val retrofit = Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//
//            return retrofit
//        }
//    }
//
//}

object ApiService {

        private const val BASE_URL = "https://api.myjson.com/bins/"

        val instance: ApiInterface by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())


            retrofit.build().create(ApiInterface::class.java)
        }
}
