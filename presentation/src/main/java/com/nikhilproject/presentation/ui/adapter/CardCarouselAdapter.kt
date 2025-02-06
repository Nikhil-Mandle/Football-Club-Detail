package com.nikhilproject.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nikhilproject.presentation.R
import com.nikhilproject.presentation.databinding.HomeCarouselItemBinding

class CardCarouselAdapter(
    private val cardImageList: List<Int>
) : RecyclerView.Adapter<CardCarouselAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val mBinding = DataBindingUtil.inflate<HomeCarouselItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.home_carousel_item,
            parent,
            false
        )
        return CardViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.setData(cardImageList[position])
    }

    override fun getItemCount(): Int = cardImageList.size

    inner class CardViewHolder(private val mBinding: HomeCarouselItemBinding) :
        RecyclerView.ViewHolder(mBinding.root) {

        fun setData(sliderImage: Int) {
            mBinding.imageView.setBackgroundResource(sliderImage)
        }
    }

}