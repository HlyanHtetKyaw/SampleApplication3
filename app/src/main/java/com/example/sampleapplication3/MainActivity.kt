package com.example.sampleapplication3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.glide.slider.library.SliderLayout
import com.glide.slider.library.animations.DescriptionAnimation
import com.glide.slider.library.slidertypes.DefaultSliderView
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {

    companion object {
        private var sliderLayout: SliderLayout? = null
        private var rvByRoom: RecyclerView? = null
        private var cvByRoom: MaterialCardView? = null
        private var cvByRates: MaterialCardView? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sliderLayout = findViewById(R.id.slider)
        rvByRoom = findViewById(R.id.rv_by_room)
        cvByRoom = findViewById(R.id.cv_by_room)
        cvByRates = findViewById(R.id.cv_by_rates)
        showBannerList()
        val llm = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvByRoom?.layoutManager = llm
        rvByRoom?.adapter = RoomAdapter(true)

        cvByRoom?.setOnClickListener {
            cvByRoom?.setCardBackgroundColor(ContextCompat.getColor(this, R.color.light_blue))
            cvByRates?.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white))
            cvByRates?.strokeColor = ContextCompat.getColor(this, R.color.light_blue)
            cvByRoom?.strokeColor = ContextCompat.getColor(this, R.color.white)
            rvByRoom?.adapter = RoomAdapter(true)
        }
        cvByRates?.setOnClickListener {
            cvByRates?.setCardBackgroundColor(ContextCompat.getColor(this, R.color.light_blue))
            cvByRoom?.setCardBackgroundColor(ContextCompat.getColor(this, R.color.white))
            cvByRoom?.strokeColor = ContextCompat.getColor(this, R.color.light_blue)
            cvByRates?.strokeColor = ContextCompat.getColor(this, R.color.white)
            rvByRoom?.adapter = RoomAdapter(false)
        }
    }

    private fun showBannerList() {
        for (i in 1..5) {
            val sliderView = DefaultSliderView(this)
            sliderView.image(R.drawable.placeholder)?.setRequestOption(
                RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE)
                    .placeholder(R.drawable.placeholder)
                    .centerCrop()
                    .error(R.drawable.placeholder)
            )
            sliderLayout?.addSlider(sliderView)
        }
        sliderLayout?.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom)
        sliderLayout?.setCustomAnimation(DescriptionAnimation())
        sliderLayout?.setDuration(3000)
        sliderLayout?.startAutoCycle()
    }
}