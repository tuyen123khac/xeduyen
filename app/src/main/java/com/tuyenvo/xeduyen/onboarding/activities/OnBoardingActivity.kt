package com.tuyenvo.xeduyen.onboarding.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.tuyenvo.xeduyen.account.activities.AccountActivity
import com.tuyenvo.xeduyen.databinding.ActivityOnBoardingBinding
import com.tuyenvo.xeduyen.onboarding.adapters.SliderAdapter
import com.tuyenvo.xeduyen.utils.Constant
import com.tuyenvo.xeduyen.utils.routeToActivityWithStringIntent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject
import kotlin.math.abs

@AndroidEntryPoint
class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding

    @Inject
    lateinit var sliderAdapter: SliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
        setupListener()
    }

    private fun setupView() {
        setupViewPager()
    }

    private fun setupListener() {
        onPressCreateAccount()
        onPressSignIn()
    }

    private fun setupViewPager() {
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }
        binding.viewPager2.apply {
            adapter = sliderAdapter
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 3
            getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            setPageTransformer(compositePageTransformer)
            registerOnPageChangeCallback(onPageChangeCallback)
        }

        binding.circleIndicator.apply {
            setViewPager(binding.viewPager2)
            sliderAdapter.registerAdapterDataObserver(adapterDataObserver)
        }
    }

    private var onPageChangeCallback = object :
        ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            setupDescriptionView(position)
            handleAutoSlide(position)
        }
    }

    private fun setupDescriptionView(position: Int) {
        binding.pageTitle.text = sliderAdapter.imageList[position].pageTitle
        binding.pageDescription.text = sliderAdapter.imageList[position].pageDescription
    }

    private fun handleAutoSlide(position: Int) {
        lifecycleScope.launchWhenResumed {
            delay(3000)
            binding.viewPager2.apply {
                if (position == adapter?.itemCount!! - 1) {
                    currentItem = 0
                } else {
                    currentItem += 1
                }
            }
        }
    }

    private fun onPressCreateAccount() {
        binding.createAccountButton.setOnClickListener {
            routeToActivityWithStringIntent(
                AccountActivity::class.java,
                Constant.ACCOUNT_ACTION_TYPE,
                Constant.SIGN_UP
            )
        }
    }

    private fun onPressSignIn() {
        binding.signInButton.setOnClickListener {
            routeToActivityWithStringIntent(
                AccountActivity::class.java,
                Constant.ACCOUNT_ACTION_TYPE,
                Constant.SIGN_IN
            )
        }
    }
}