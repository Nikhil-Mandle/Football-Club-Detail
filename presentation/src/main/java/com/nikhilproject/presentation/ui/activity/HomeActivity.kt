package com.nikhilproject.presentation.ui.activity


import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.nikhilproject.presentation.ui.adapter.FootballClubCarouselAdapter
import com.nikhilproject.presentation.ui.adapter.PlayerDetailAdapter
import com.nikhilproject.presentation.ui.dialog.BottomSheetDialog
import com.nikhilproject.presentation.utils.extension.ViewExtension.showToast
import com.nikhilproject.presentation.utils.extension.ViewExtension.visibilityToggle
import com.google.android.material.tabs.TabLayoutMediator
import com.nikhilproject.domain.model.PlayerDetail
import com.nikhilproject.presentation.R
import com.nikhilproject.presentation.base.BaseActivity
import com.nikhilproject.presentation.databinding.ActivityHomeBinding
import com.nikhilproject.presentation.state.HomeUiState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {

    private val homeViewModel: HomeViewModel by viewModel()

    private lateinit var playerDetailAdapter: PlayerDetailAdapter
    private lateinit var footballClubCarouselAdapter: FootballClubCarouselAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
    }

    override fun observeViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    homeViewModel.homeUiState.collectLatest { state ->
                        when (state) {
                            is HomeUiState.Success -> {
                                dataBinding.progressBar.visibilityToggle(false)
                                homeViewModel.currentSelectedItem.value = 0
                                setDataAdapter(
                                    carouselData = state.carouselImages ?: emptyList(),
                                )
                            }

                            is HomeUiState.Loading -> {
                                dataBinding.progressBar.visibilityToggle(true)
                            }

                            is HomeUiState.Error -> {
                                dataBinding.progressBar.visibilityToggle(false)
                                val message = state.stringMessage ?: getString(
                                    state.resourceId ?: R.string.generic_error
                                )
                                showToast(message)
                            }

                            else -> {

                            }
                        }
                    }
                }

                launch {
                    homeViewModel.playerDetailList.collectLatest { list ->
                        setPlayerDetailAdapter(list)
                    }
                }
            }
        }
    }

    override fun initViews() {
        dataBinding.fab.setOnClickListener {
            val bottomSheetDetails = homeViewModel.bottomSheetInsights.value
            val modal = BottomSheetDialog(bottomSheetDetails)
            supportFragmentManager.let { modal.show(it, BottomSheetDialog.TAG) }

        }

        dataBinding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                query?.let {
                    homeViewModel.searchQuery.value = query
                }
                return true
            }
        })

        dataBinding.homeCarousel.viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                homeViewModel.currentSelectedItem.value = position
                resetSearchQuery()
            }
        })
    }


    private fun setDataAdapter(
        carouselData: List<Int>
    ) {
        footballClubCarouselAdapter = FootballClubCarouselAdapter(carouselData)
        dataBinding.apply {
            homeCarousel.viewPager.adapter = footballClubCarouselAdapter
            TabLayoutMediator(homeCarousel.tabLayout, homeCarousel.viewPager) { tab, position ->
            }.attach()
        }
    }

    private fun setPlayerDetailAdapter(
        playerDetail: List<PlayerDetail>
    ) {
        playerDetailAdapter = PlayerDetailAdapter(playerDetail)
        dataBinding.apply {
            itemList.adapter = playerDetailAdapter
            itemList.layoutManager = LinearLayoutManager(this@HomeActivity)

        }
    }


    fun resetSearchQuery() {
        dataBinding.search.setQuery("", false)
        dataBinding.search.clearFocus()
    }
}