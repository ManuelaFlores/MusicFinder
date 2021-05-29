package com.manuflowers.musicfinder.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.manuflowers.musicfinder.R
import com.manuflowers.musicfinder.ui.home.list.HomeAdapter
import com.manuflowers.musicfinder.ui.home.model.HomeViewState
import com.manuflowers.musicfinder.ui.home.model.TrackView
import com.manuflowers.musicfinder.ui.home.viewModel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val homeViewModel: HomeViewModel by inject()

    private val homeAdapter by lazy {
        HomeAdapter(::onClickListener)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        homeRecyclerView.adapter = homeAdapter
        homeViewModel.getSearchResults("")
        observeOnErrorEvent()
        observeState(::onStateChanged)
        setupSearch()
    }

    private fun setupSearch() {
        searchEditText.addTextChangedListener (object : TextWatcher {
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
        // TODO: 29/05/21 , initialize new activity
    }

    private fun onStateChanged(homeViewState: HomeViewState) {
        if (homeViewState.searchResults.isNotEmpty()) {
            homeAdapter.setData(homeViewState.searchResults)
        }

        homeViewState.isLoading.consume()?.let {
            loadingLayout.isVisible = it
            if (!it) {
                emptyLayout.isVisible = homeViewState.searchResults.isEmpty()
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