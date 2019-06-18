package com.gojeck.apps.whertherly.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.gojeck.apps.whertherly.R
import com.gojeck.apps.whertherly.model.Forecastday
import kotlinx.android.synthetic.main.list_item.view.*

class ForecastAdapter : RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {
    var forecastday: List<Forecastday>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item,
                null
            )
        )
    }

    override fun getItemCount(): Int {
        return forecastday?.size ?: 0
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        forecastday?.run {
            holder.bindForecast(get(position))
        }

    }


    inner class ForecastViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecastday) {
            itemView.day.text = forecast.date
            itemView.temperature.text =
                view.context.getString(R.string.celsius, forecast.day.avgtempC)
        }
    }
}