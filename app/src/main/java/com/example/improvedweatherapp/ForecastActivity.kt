package com.example.improvedweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ForecastActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var api: Api





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)


        recyclerView = findViewById(R.id.recyclerView)
       recyclerView.layoutManager = LinearLayoutManager(this)

        //recyclerView.adapter = MyAdapter(adapterData)


        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://pro.openweathermap.org/data/2.5/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        api = retrofit.create(Api::class.java)




    }

    override fun onResume() {
        super.onResume()
        val call: Call<Forecast> = api.getForecast("55118")
        call.enqueue(object : Callback<Forecast> {
            override fun onResponse(
                call: Call<Forecast>,
                response: Response<Forecast>
            ) {
                val forecastConditions = response.body()
                forecastConditions?.let { bindData(it)}

            }

            override fun onFailure(call: Call<Forecast>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }


    private fun bindData(forecast: Forecast) {
        recyclerView.adapter = MyAdapter(forecast.list)

    }



}