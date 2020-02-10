package com.rjt.retrofit.network

import com.rjt.retrofit.model.EmployeeList
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("kp9wz")
    fun getEmployee() : Call<EmployeeList>
}