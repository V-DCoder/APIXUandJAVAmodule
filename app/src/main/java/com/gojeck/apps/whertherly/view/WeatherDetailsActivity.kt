package com.gojeck.apps.whertherly.view

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.AnimationUtils
import com.gojeck.apps.whertherly.R
import com.gojeck.apps.whertherly.adapter.ForecastAdapter
import com.gojeck.apps.whertherly.model.ForecastResponse
import com.gojeck.apps.whertherly.viewmodel.WeatherDetailsViewModel
import kotlinx.android.synthetic.main.weather_details_activity.*


class WeatherDetailsActivity : AppCompatActivity() {

    private val PERMISSION_REQUEST_CODE = 9
    var locationManager: LocationManager? = null
    var viewModel: WeatherDetailsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_details_activity)
        viewModel = ViewModelProviders.of(this).get(WeatherDetailsViewModel::class.java)
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        initObservers()
        retry.setOnClickListener { onRetry() }

    }


    private fun initObservers() {
        viewModel?.getErrorLiveData()?.observe(this, Observer { onErrorUI() })
        viewModel?.getProgressDialogLiveData()?.observe(this, Observer { showProgressBar(it) })
        viewModel?.getLocationForecastLiveData()?.observe(this, Observer { onSuccess(it) })
    }

    private fun showProgressBar(showDialog: Boolean?) {
        if (showDialog == true) {
            progress.visibility = View.VISIBLE
        } else {
            progress.visibility = View.GONE
        }
    }

    private fun onErrorUI() {
        error_container.visibility = View.VISIBLE
    }

    private fun onRetry() {
        error_container.visibility = View.GONE
        if (checkLocationPermissionGranted())
            viewModel?.getLocationUpdate(locationManager)
        else
            requestPermission()
    }

    override fun onStart() {
        super.onStart()
        if (checkLocationPermissionGranted()) {
            viewModel?.getLocationUpdate(locationManager)
        } else {
            requestPermission()
            return
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel?.removeListeners(locationManager)
    }


    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION),
            PERMISSION_REQUEST_CODE
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                for (i in grantResults.indices) {
                    if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                        viewModel?.onPermissionDenied()
                        return
                    }
                    viewModel?.getLocationUpdate(locationManager)
                }
            }
        }
    }

    private fun checkLocationPermissionGranted(): Boolean {
        val fineLocation =
            ContextCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION)
        val coarseLocation =
            ContextCompat.checkSelfPermission(this, ACCESS_COARSE_LOCATION)

        return fineLocation == PackageManager.PERMISSION_GRANTED && coarseLocation == PackageManager.PERMISSION_GRANTED
    }


    private fun onSuccess(it: ForecastResponse?) {
        error_container.visibility = View.GONE
        progress.visibility = View.GONE
        currentTemperature.text = getString(R.string.current_temperature, it?.current?.tempC)
        currentCity.text = it?.location?.name
        val adapter = ForecastAdapter()
        adapter.forecastday = it?.forecast?.forecastday
        forecast.adapter = adapter
        animateRecyclerView()
    }

    private fun animateRecyclerView() {
        forecast.visibility = View.VISIBLE
        val slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up_animation)
        forecast.startAnimation(slideUp)

    }


}