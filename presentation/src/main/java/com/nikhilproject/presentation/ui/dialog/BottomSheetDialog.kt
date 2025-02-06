package com.nikhilproject.presentation.ui.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.nikhilproject.presentation.databinding.BottomSheetDialogBinding
import com.nikhilproject.presentation.model.BottomSheetInsights
import com.nikhilproject.presentation.utils.extension.BottomSheetFormatter.formatBottomSheetItem

class BottomSheetDialog(
    private val bottomSheetInsights: BottomSheetInsights
) : BottomSheetDialogFragment() {

    private lateinit var mBinding: BottomSheetDialogBinding

    companion object {
        const val TAG = "ModalBottomSheetDialog"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = BottomSheetDialogBinding.inflate(
            inflater,
            container,
            false
        )
        setBottomSheetData()
        return mBinding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dialog?.setOnShowListener {
            val bottomSheetDialog = it as BottomSheetDialog
            val bottomSheet =
                bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.let { view ->
                val behavior = BottomSheetBehavior.from(view)
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return super.onCreateDialog(savedInstanceState)
    }

    private fun setBottomSheetData() {
        val characterList = bottomSheetInsights.characterOccurrences.entries.toList()
        bottomSheetInsights.itemCount.let {
            mBinding.tvItemCount.tvTextView.text = it.toString()
        }
        characterList[0].let { pair ->
            mBinding.tvFirstTopCharacter.lblTextView.text =
                pair.key.formatBottomSheetItem()
            mBinding.tvFirstTopCharacter.tvTextView.text = pair.value.toString()
        }
        characterList[1].let { pair ->
            mBinding.tvSecondTopCharacter.lblTextView.text =
                pair.key.formatBottomSheetItem()
            mBinding.tvSecondTopCharacter.tvTextView.text = pair.value.toString()
        }

        characterList[2].let { pair ->
            mBinding.tvThirdTopCharacter.lblTextView.text =
                pair.key.formatBottomSheetItem()
            mBinding.tvThirdTopCharacter.tvTextView.text = pair.value.toString()
        }
    }
}