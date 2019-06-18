package com.gojeck.apps.whertherly.model

import com.gojeck.apps.whertherly.repository.APIProvider
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkManager {

    fun getForcast(lat: Double?,long: Double?, days: Int): Single<ForecastResponse> {

        var retrofit =
            Retrofit.Builder().baseUrl("https://api.apixu.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        var caller = retrofit.create(APIProvider::class.java)
        return caller.getCurrentForecast("7d01c65f0cf548e0bb8184008191006", "$lat,$long", days)
    }
}