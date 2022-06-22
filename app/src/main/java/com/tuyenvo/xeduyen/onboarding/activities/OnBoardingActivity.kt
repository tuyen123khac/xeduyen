package com.tuyenvo.xeduyen.onboarding.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.tuyenvo.xeduyen.R
import com.tuyenvo.xeduyen.databinding.ActivityOnBoardingBinding
import com.tuyenvo.xeduyen.onboarding.adapters.SliderAdapter
import com.tuyenvo.xeduyen.onboarding.models.SliderItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.FieldPosition

class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {
        val dummyList = listOf(
            SliderItem("https://images.unsplash.com/flagged/photo-1570700005880-4ecdb8595d4a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8YmVhY2glMjBnaXJsfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60"),
            SliderItem("https://images.unsplash.com/photo-1542295669297-4d352b042bca?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8c21pbGUlMjBnaXJsfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60"),
            SliderItem("https://images.unsplash.com/photo-1617059070087-d05ea39977dd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NjR8fGJlYWNoJTIwZ2lybHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60"),
        )

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }

        val sliderAdapter = SliderAdapter(dummyList, binding.viewPager2)

        binding.viewPager2.apply {
            adapter = sliderAdapter
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            setPageTransformer(compositePageTransformer)
            registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    Log.e("WTF", "handleAutoSlide: position : $position")
                    handleAutoSlide(position)
                }
            })
        }

        binding.circleIndicator.apply {
            setViewPager(binding.viewPager2)
            sliderAdapter.registerAdapterDataObserver(adapterDataObserver)

        }
    }

    private fun handleAutoSlide(position: Int) {
        lifecycleScope.launchWhenResumed {
            delay(3000)
            binding.viewPager2.apply {
                if (position == adapter?.itemCount!! - 1){
                    currentItem = 0
                } else {
                    currentItem += 1
                }
            }
        }
    }
}