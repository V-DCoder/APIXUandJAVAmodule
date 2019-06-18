package com.gojeck.apps.whertherly.viewmodel

import android.arch.lifecycle.ViewModel
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle

import android.util.Log



class WeatherDetailsViewModel : ViewModel(), LocationListener {

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

    }

    override fun onProviderEnabled(provider: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderDisabled(provider: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onLocationChanged(location: Location?) {
        Log.w("onLocationChanged","bearing "+location?.bearing)
        Log.w("onLocationChanged","longitude "+location?.longitude)
        Log.w("onLocationChanged","latitude "+location?.latitude)
        Log.w("onLocationChanged","provider "+location?.provider)
    }


    fun getLocationUpdate(locationManager: LocationManager?) {

        try {
            locationManager?.let {
                val criteria = Criteria()
                var provider = locationManager?.getBestProvider(criteria, false)
                locationManager.requestLocationUpdates(provider,5000,1000.0f,this@WeatherDetailsViewModel)

            }
        }catch (securityException : SecurityException)
        {
            securityException.printStackTrace()
        }


    }

    fun onPermissionDenied() {

    }

}