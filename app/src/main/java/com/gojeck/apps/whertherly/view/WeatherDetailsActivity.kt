package com.gojeck.apps.whertherly.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gojeck.apps.whertherly.R
import kotlinx.android.synthetic.main.weather_details_activity.*

class WeatherDetailsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weather_details_activity)


    }

    private fun changeVisibility() {
        if (progress.visibility == View.VISIBLE) {

            progress.visibility = View.GONE
        } else {
            progress.visibility = View.VISIBLE
        }
    }
}