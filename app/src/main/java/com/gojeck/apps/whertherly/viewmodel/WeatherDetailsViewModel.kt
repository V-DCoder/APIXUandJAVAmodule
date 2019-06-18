package com.gojeck.apps.whertherly.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import com.gojeck.apps.whertherly.model.ForecastResponse
import com.gojeck.apps.whertherly.model.NetworkManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class WeatherDetailsViewModel : ViewModel(), LocationListener {

    private var errorFound: MutableLiveData<Boolean> = MutableLiveData()
    private var showProgress: MutableLiveData<Boolean> = MutableLiveData()
    private var locationForecast: MutableLiveData<ForecastResponse> = MutableLiveData()
    private var compositeDisposable = CompositeDisposable()

    fun getLocationForecastLiveData(): LiveData<ForecastResponse> {
        return locationForecast
    }

    fun getProgressDialogLiveData(): LiveData<Boolean> {
        return showProgress
    }

    fun getErrorLiveData(): LiveData<Boolean> {
        return errorFound
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

    }

    override fun onProviderEnabled(provider: String?) {

    }

    override fun onProviderDisabled(provider: String?) {

    }


    override fun onLocationChanged(location: Location?) {

        compositeDisposable.add(
            NetworkManager().getForcast(
                location?.latitude,
                location?.longitude,
                7
            ).subscribeOn(
                Schedulers.io()
            )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    showProgress.postValue(false)
                    locationForecast.postValue(it)
                }, {
                    showProgress.postValue(false)
                    errorFound.postValue(true)
                })
        )
    }


    fun getLocationUpdate(locationManager: LocationManager?) {
        showProgress.postValue(true)
        try {
            locationManager?.let {
                val criteria = Criteria()
                val lst = locationManager.getProviders(true)
                locationManager.getBestProvider(criteria, true)
                locationManager.requestLocationUpdates(
                    "network",
                    50000,
                    1000.0f,
                    this@WeatherDetailsViewModel
                )
            }
        } catch (securityException: SecurityException) {
            securityException.printStackTrace()
        }


    }

    fun onPermissionDenied() {
        errorFound.postValue(true)
    }

}