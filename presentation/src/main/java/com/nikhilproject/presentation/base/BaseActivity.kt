package com.nikhilproject.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


abstract class BaseActivity<DB : ViewDataBinding>(@LayoutRes val layoutResId: Int) :
    AppCompatActivity(layoutResId) {

    protected lateinit var dataBinding: DB

    abstract fun observeViewModel()

    abstract fun initViews()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewBinding()
        observeViewModel()
        initViews()
    }

    private fun initViewBinding() {
        dataBinding = DataBindingUtil.setContentView(this, layoutResId)
        setContentView(dataBinding.root)
        observeViewModel()
    }
}