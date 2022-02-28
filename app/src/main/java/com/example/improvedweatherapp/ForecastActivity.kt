package com.example.improvedweatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ForecastActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    val adapterData = listOf<DayForecast>(
        DayForecast(
            1642218360, 1642230000, 1642269600, ForecastTemp(
                72F,
                50F,
                40F
            )
        ),
       DayForecast(1642304760,1642230000,1642269600,ForecastTemp(
           72F,
           50F,
           40F
       )),
        DayForecast(1642391160,1642230000,1642269600,ForecastTemp(
            72F,
            50F,
            40F
        )),
        DayForecast(1642477560,1642230000,1642269600,ForecastTemp(
            72F,
            50F,
            40F
        )),
        DayForecast(1642563960,1642230000,1642269600,ForecastTemp(
            72F,
            50F,
            40F
        )),
        DayForecast(1642650360,1642230000,1642269600,ForecastTemp(
            72F,
            50F,
            40F
        )),
        DayForecast(1642736760,1642230000,1642269600,ForecastTemp(
            72F,
            50F,
            40F
        )),
        DayForecast(1642823160,1642230000,1642269600,ForecastTemp(
            72F,
            50F,
            40F
        )),
        DayForecast(1642909560,1642230000,1642269600,ForecastTemp(
            72F,
            50F,
            40F
        )),
        DayForecast(1642995960,1642230000,1642269600,ForecastTemp(
            72F,
            50F,
            40F
        )),
        DayForecast(1643082360,1642230000,1642269600,ForecastTemp(
            72F,
            50F,
            40F
        )),
        DayForecast(1643168760,1642230000,1642269600,ForecastTemp(
            72F,
            50F,
            40F
        )),
        DayForecast(1643255160,1642230000,1642269600,ForecastTemp(
            72F,
            50F,
            40F
        )),
        DayForecast(1643341560,1642230000,1642269600,ForecastTemp(
            72F,
            50F,
            40F
        )),
        DayForecast(1643427960,1642230000,1642269600,ForecastTemp(
            72F,
            50F,
            40F
        )),
        DayForecast(1643514360,1642230000,1642269600,ForecastTemp(
            72F,
            50F,
            40F
        )),


    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)


        recyclerView = findViewById(R.id.recyclerView)
       recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = MyAdapter(adapterData)




    }
}