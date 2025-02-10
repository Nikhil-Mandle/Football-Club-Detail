package com.nikhilproject.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nikhilproject.domain.model.PlayerDetail
import com.nikhilproject.presentation.R
import com.nikhilproject.presentation.databinding.PlayerDetailItemBinding

class PlayerDetailAdapter(
    private val playerDetailList: List<PlayerDetail>
) : RecyclerView.Adapter<PlayerDetailAdapter.PlayerDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerDetailViewHolder {
        val mBinding = DataBindingUtil.inflate<PlayerDetailItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.player_detail_item,
            parent,
            false
        )
        return PlayerDetailViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: PlayerDetailViewHolder, position: Int) {
        holder.bindData(playerDetail = playerDetailList[position])
    }

    override fun getItemCount(): Int = playerDetailList.size

    inner class PlayerDetailViewHolder(private val mBinding: PlayerDetailItemBinding) :
        RecyclerView.ViewHolder(mBinding.root) {

        fun bindData(playerDetail: PlayerDetail) {
            mBinding.cardName.text = playerDetail.name
            mBinding.cardDescription.text = playerDetail.description
            mBinding.cardImage.setBackgroundResource(playerDetail.image)
        }
    }
}