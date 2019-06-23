package com.gojeck.apps.whertherly.repository

import com.gojeck.apps.whertherly.model.ForecastResponse
import io.reactivex.Single

interface ForecastRepository {

    fun getForecast(lat: Double?, long: Double?, days: Int): Single<ForecastResponse>
}