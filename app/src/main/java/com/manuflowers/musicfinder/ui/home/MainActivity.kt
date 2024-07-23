package com.manuflowers.musicfinder.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.manuflowers.musicfinder.R
import com.manuflowers.musicfinder.databinding.ActivityMainBinding
import com.manuflowers.musicfinder.ui.home.list.HomeAdapter
import com.manuflowers.musicfinder.ui.home.model.HomeViewState
import com.manuflowers.musicfinder.ui.home.model.TrackView
import com.manuflowers.musicfinder.ui.home.viewModel.HomeViewModel
import com.manuflowers.musicfinder.ui.trackDetail.TrackDetailActivity
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val homeViewModel: HomeViewModel by inject()

    private lateinit var binding: ActivityMainBinding

    private val homeAdapter by lazy {
        HomeAdapter(::onClickListener)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.homeRecyclerView.adapter = homeAdapter
        homeViewModel.getSearchResults("")
        observeOnErrorEvent()
        observeState(::onStateChanged)
        setupSearch()
    }

    private fun setupSearch() {
        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                Log.e("QUERY", s.toString())
                homeViewModel.getSearchResults(s.toString())
            }
        })
    }

    private fun onClickListener(trackView: TrackView) {
        startActivity(Intent(this, TrackDetailActivity::class.java).also {
            it.putExtra("TRACK_DETAIL", trackView)
        })
    }

    private fun onStateChanged(homeViewState: HomeViewState) {
        if (homeViewState.searchResults.isNotEmpty()) {
            homeAdapter.setData(homeViewState.searchResults)
        }

        homeViewState.isLoading.consume()?.let {
            binding.run {
                loadingLayout.root.isVisible = it
                if (!it) {
                    emptyLayout.root.isVisible = homeViewState.searchResults.isEmpty()
                }
            }
        }


        Log.e("SEARCH", "${homeViewState.searchResults}")
    }

    private fun observeState(onStateChanged: (homeViewState: HomeViewState) -> Unit) {
        val observer = Observer<HomeViewState> { viewState ->
            onStateChanged.invoke(viewState)
        }
        homeViewModel.viewState.observe(this, observer)
        observer.onChanged(homeViewModel.state)
    }

    private fun observeOnErrorEvent() {
        homeViewModel.onErrorEvent.observe(this, Observer { event ->
            event.consume()?.let {
                if (it) showErrorDialog()
            }
        })
    }

    private fun showErrorDialog() {
        Toast.makeText(this, getString(R.string.error_message), Toast.LENGTH_SHORT).show()
    }
}