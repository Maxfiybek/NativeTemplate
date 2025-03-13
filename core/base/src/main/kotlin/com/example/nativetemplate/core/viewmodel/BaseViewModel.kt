package com.example.nativetemplate.core.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import org.koin.core.component.KoinComponent

abstract class BaseViewModel<STATE, EVENT, EFFECT>(initialState: STATE) : ViewModel(),
    KoinComponent {

    protected val mutableState: MutableStateFlow<STATE> = MutableStateFlow(initialState)
    val state: StateFlow<STATE> = mutableState.asStateFlow()

    protected val mutableEffects = Channel<EFFECT>(Channel.Factory.BUFFERED)
    val effects = mutableEffects.receiveAsFlow()

    protected val mutableErrorEffects = Channel<String>(Channel.Factory.BUFFERED)
    val errorEffects = mutableErrorEffects.receiveAsFlow()

    protected suspend fun sendEffect(effect: EFFECT) {
        mutableEffects.send(effect)
    }

    abstract fun onEvent(event: EVENT)
}