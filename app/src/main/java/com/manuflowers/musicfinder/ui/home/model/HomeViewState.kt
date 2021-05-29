package com.manuflowers.musicfinder.ui.home.model

import com.manuflowers.musicfinder.base.BaseViewState
import com.manuflowers.musicfinder.base.SingleEvent

data class HomeViewState(
    val isLoading: SingleEvent<Boolean> = SingleEvent(false),
    val searchResults: List<TrackView> = listOf(),
    val searchQuery: String = ""
): BaseViewState