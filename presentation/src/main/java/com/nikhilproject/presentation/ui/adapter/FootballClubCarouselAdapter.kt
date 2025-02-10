package com.nikhilproject.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nikhilproject.presentation.R
import com.nikhilproject.presentation.databinding.HomeCarouselItemBinding

class FootballClubCarouselAdapter(
    private val footballClubImageList: List<Int>
) : RecyclerView.Adapter<FootballClubCarouselAdapter.FootballClubViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballClubViewHolder {
        val mBinding = DataBindingUtil.inflate<HomeCarouselItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.home_carousel_item,
            parent,
            false
        )
        return FootballClubViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: FootballClubViewHolder, position: Int) {
        holder.setData(footballClubImageList[position])
    }

    override fun getItemCount(): Int = footballClubImageList.size

    inner class FootballClubViewHolder(private val mBinding: HomeCarouselItemBinding) :
        RecyclerView.ViewHolder(mBinding.root) {

        fun setData(sliderImage: Int) {
            mBinding.imageView.setBackgroundResource(sliderImage)
        }
    }

}