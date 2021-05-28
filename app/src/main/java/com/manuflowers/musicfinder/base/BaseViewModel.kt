package com.manuflowers.musicfinder.base

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.manuflowers.domain.utils.Result
import com.manuflowers.domain.utils.Success

abstract class BaseViewModel<VS: BaseViewState>: ViewModel() {
    abstract val initialState: VS

    val viewState: MediatorLiveData<VS> = MediatorLiveData()
    val onErrorEvent: MutableLiveData<SingleEvent<Boolean>> = MutableLiveData()

    var state: VS
    get() = viewState.value ?: initialState
    set(value) = viewState.setValue(value) // Sets the value synchronously

    var stateAsync: VS
        get() = state
        set(value) = viewState.postValue(value) // Sets the value asynchronously

    open fun handleResult(result: Result<*>): Boolean {
        return when (result) {
            is Success<*> -> false
            else -> {
                onErrorEvent.postValue(SingleEvent(true))
                true
            }
        }
    }
}