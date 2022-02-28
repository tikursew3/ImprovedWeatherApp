package com.example.improvedweatherapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class MyAdapter(private val data: List<DayForecast>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val weatherIcon: ImageView = view.findViewById(R.id.weather_icon)
        private val dateView: TextView = view.findViewById(R.id.date)
        private val tempView: TextView = view.findViewById(R.id.temp)
        private val highView: TextView = view.findViewById(R.id.high)
        private val lowView: TextView = view.findViewById(R.id.low)
        private val sunriseView: TextView = view.findViewById(R.id.sunrise)
        private val sunsetView: TextView = view.findViewById(R.id.sunset)


        @SuppressLint("NewApi")
        fun bind(data: DayForecast) {

            val instant = Instant.ofEpochSecond(data.date)
            val dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
            val formatter = DateTimeFormatter.ofPattern("MMM dd")

            dateView.text = formatter.format(dateTime)

            tempView.text = "Temp: " + data.temp.day.toInt() + "°"
            //tempView.text = "Temp: " + data.temp.day.toInt() + "°"
            highView.text = "High: " + data.temp.max.toInt() + "°"
            lowView.text = "Low: " +  data.temp.min.toInt() + "°"

            val sunriseInstant = Instant.ofEpochSecond(data.sunrise)
            val sunriseTime = LocalDateTime.ofInstant(sunriseInstant, ZoneId.systemDefault())
            val sunriseFormatter = DateTimeFormatter.ofPattern("hh mm a")

            sunriseView.text = "sunrise: " + sunriseFormatter.format(sunriseTime)

            val sunsetInstant = Instant.ofEpochSecond(data.sunset)
            val sunsetTime = LocalDateTime.ofInstant(sunsetInstant, ZoneId.systemDefault())
            val sunsetFormatter = DateTimeFormatter.ofPattern("hh mm a")

            sunsetView.text = "sunset: " + sunsetFormatter.format(sunsetTime)



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_date, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size


}