package com.manuflowers.musicfinder.ui.home.model

import com.manuflowers.domain.search.model.TrackEntity
import com.manuflowers.musicfinder.base.BaseViewState
import com.manuflowers.musicfinder.base.SingleEvent

data class HomeViewState(
    val isLoading: SingleEvent<Boolean> = SingleEvent(false),
    val searchResults: List<TrackEntity> = listOf()
): BaseViewState