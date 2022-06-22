package com.tuyenvo.xeduyen.onboarding.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.tuyenvo.xeduyen.R
import com.tuyenvo.xeduyen.databinding.OnBoardingImageItemBinding
import com.tuyenvo.xeduyen.onboarding.models.SliderItem

class SliderAdapter(private val imageList: List<SliderItem>, private val viewPager2: ViewPager2) : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val itemBinding = OnBoardingImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SliderViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        val sliderItem = imageList[position]
        holder.bind(sliderItem)
    }

    override fun getItemCount(): Int = imageList.size

    class SliderViewHolder(private val itemBinding: OnBoardingImageItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(sliderItem: SliderItem) {
            Glide
                .with(itemBinding.roundedImageView.context)
                .load(sliderItem.imageUrl)
                .placeholder(R.drawable.ic_image_placeholder)
                .into(itemBinding.roundedImageView)
        }
    }
}