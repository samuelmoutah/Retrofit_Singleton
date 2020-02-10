package com.rjt.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.rjt.retrofit.model.EmployeeList
import com.rjt.retrofit.network.ApiInterface
import com.rjt.retrofit.network.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val call = ApiService.getClient().create(ApiInterface::class.java).getEmployee()

        val call = ApiService.instance.getEmployee()

        call.enqueue(object : Callback<EmployeeList>{
            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<EmployeeList>, t: Throwable) {
                Log.e("retrofit", t.message)
            }

            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(call: Call<EmployeeList>, response: Response<EmployeeList>) {

                val list = response.body()!!.employees

                //Log.d("Retrofit", "success" + response.body().toString())

                text_view_name.text = list.get(0).firstname


            }

        })
    }
}
