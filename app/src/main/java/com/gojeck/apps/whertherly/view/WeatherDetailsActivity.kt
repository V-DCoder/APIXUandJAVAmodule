package com.gojeck.apps.whertherly.view

import android.content.Context
import android.graphics.LinearGradient
import android.location.LocationManager
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gojeck.apps.whertherly.R
import com.gojeck.apps.whertherly.adapter.ForecastAdapter
import com.gojeck.apps.whertherly.model.ForecastResponse
import com.gojeck.apps.whertherly.model.Forecastday
import com.gojeck.apps.whertherly.model.NetworkManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.weather_details_activity.*
import retrofit2.Call
import android.location.Criteria






class WeatherDetailsActivity : AppCompatActivity() {

    private var provider: String? = null
    var locationManager :LocationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_details_activity)

         locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager


        val criteria = Criteria()
        provider = locationManager?.getBestProvider(criteria, false)
        val location = locationManager?.getLastKnownLocation(provider)



        setForecat()
    }

    override fun onResume() {
        super.onResume()
        locationManager.requestLocationUpdates(provider, 400, 1, this)
    }

    /* Remove the locationlistener updates when Activity is paused */
    override fun onPause() {
        super.onPause()

    }

    private fun setForecat() {
        var lst = ArrayList<Forecastday>()

        NetworkManager().getForcast("",4).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({onSuccess(it)},{it.stackTrace})


    }

    private fun onSuccess(it: ForecastResponse?) {
        Log.w("sas","ddit" + it?.current?.windKph)
        currentTemperature.text = getString(R.string.current_temperature,it?.current?.tempC)
        var adapter = ForecastAdapter()
        adapter.forecastday = it?.forecast?.forecastday
        forecast.adapter = adapter


    }


}