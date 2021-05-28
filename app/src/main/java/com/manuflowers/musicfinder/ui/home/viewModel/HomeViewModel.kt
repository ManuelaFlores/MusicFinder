package com.manuflowers.musicfinder.ui.home.viewModel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.manuflowers.domain.search.GetSearchResultUseCase
import com.manuflowers.domain.search.model.TrackEntity
import com.manuflowers.domain.utils.Error
import com.manuflowers.domain.utils.Result
import com.manuflowers.domain.utils.Success
import com.manuflowers.musicfinder.base.BaseViewModel
import com.manuflowers.musicfinder.base.SingleEvent
import com.manuflowers.musicfinder.ui.home.model.HomeViewState
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getSearchResultUseCase: GetSearchResultUseCase
) : BaseViewModel<HomeViewState>() {
    override val initialState = HomeViewState()

    init {
        viewState.value = initialState
    }

    fun getSearchResults(query: String) {
        state = state.copy(
            isLoading = SingleEvent(true)
        )
        viewModelScope.launch {
            handleResult(
                getSearchResultUseCase.getSearchResult(
                    query = query,
                    mediaType = "music",
                    limit = "20"
                )
            )
        }
    }

    private fun handleResult(result: Result<List<TrackEntity>>) {
        when (result) {
            is Success -> {
                stateAsync = state.copy(
                    isLoading = SingleEvent(false),
                    searchResults = result.data
                )
            }
            is Error -> {
                Log.e("SEARCH_ERROR", "${result.message}")
                stateAsync = state.copy(
                    isLoading = SingleEvent(false)
                )
                super.handleResult(result)
            }
        }
    }
}