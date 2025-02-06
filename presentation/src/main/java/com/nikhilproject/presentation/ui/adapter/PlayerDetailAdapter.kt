package com.nikhilproject.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nikhilproject.domain.model.PlayerDetail
import com.nikhilproject.presentation.R
import com.nikhilproject.presentation.databinding.RewardItemBinding

class PlayerDetailAdapter(
    private val playerDetailList: List<PlayerDetail>
) : RecyclerView.Adapter<PlayerDetailAdapter.RewardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardViewHolder {
        val mBinding = DataBindingUtil.inflate<RewardItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.reward_item,
            parent,
            false
        )
        return RewardViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: RewardViewHolder, position: Int) {
        holder.bindData(reward = playerDetailList[position])
    }

    override fun getItemCount(): Int = playerDetailList.size

    inner class RewardViewHolder(private val mBinding: RewardItemBinding) :
        RecyclerView.ViewHolder(mBinding.root) {

        fun bindData(reward: PlayerDetail) {
            mBinding.cardName.text = reward.name
            mBinding.cardDescription.text = reward.description
            mBinding.cardImage.setBackgroundResource(reward.image)
        }
    }
}