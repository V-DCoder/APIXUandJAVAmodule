package com.gojeck.apps.whertherly.network

import com.gojeck.apps.whertherly.BuildConfig
import com.gojeck.apps.whertherly.model.ForecastResponse
import com.gojeck.apps.whertherly.repository.ForecastRepository
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class NetworkRepository : ForecastRepository {

        private val retrofit =
            Retrofit.Builder().baseUrl("https://api.apixu.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        private var service = retrofit.create(APIProvider::class.java)

    override fun getForecast(lat: Double?, long: Double?, days: Int): Single<ForecastResponse> {
        return service.getCurrentForecast(BuildConfig.APIXU_SECRET, "$lat,$long", days)
    }

}