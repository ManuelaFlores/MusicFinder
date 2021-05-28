package com.manuflowers.musicfinder.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.manuflowers.musicfinder.R
import com.manuflowers.musicfinder.ui.home.list.HomeAdapter
import com.manuflowers.musicfinder.ui.home.model.HomeViewState
import com.manuflowers.musicfinder.ui.home.viewModel.HomeViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val homeViewModel: HomeViewModel by inject()

    private val homeAdapter by lazy {
        HomeAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homeViewModel.getSearchResults("love")
        observeOnErrorEvent()
        observeState(::onStateChanged)
    }

    private fun observeState(onStateChanged: (homeViewState: HomeViewState) -> Unit) {
        val observer = Observer<HomeViewState> { viewState ->
            onStateChanged.invoke(viewState)
        }
        homeViewModel.viewState.observe(this, observer)
        observer.onChanged(homeViewModel.state)
    }

    private fun onStateChanged(homeViewState: HomeViewState) {
        // TODO
        Log.e("SEARCH", "${homeViewState.searchResults}")
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