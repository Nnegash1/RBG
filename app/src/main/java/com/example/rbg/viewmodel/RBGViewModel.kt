package com.example.rbg.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RBGViewModel : ViewModel() {
    private val _colorR: MutableStateFlow<Int> = MutableStateFlow(250)
    val colorR = _colorR.asStateFlow()
    private val _colorB: MutableStateFlow<Int> = MutableStateFlow(250)
    val colorB = _colorB.asStateFlow()
    private val _colorG: MutableStateFlow<Int> = MutableStateFlow(250)
    val colorG = _colorG.asStateFlow()

    fun addR(multiplayer: Int) = viewModelScope.launch {
        if ((_colorR.value + multiplayer) <= 250) {
            _colorR.value += multiplayer
        }
    }

    fun subR(multiplayer: Int) = viewModelScope.launch {
        if ((_colorR.value - multiplayer) >= 0) {
            _colorR.value -= multiplayer
        }
    }

    fun addB(multiplayer: Int) = viewModelScope.launch {
        if ((_colorB.value + multiplayer) <= 250) {
            _colorB.value += multiplayer
        }
    }

    fun subB(multiplayer: Int) = viewModelScope.launch {
        if ((_colorB.value - multiplayer) >= 0) {
            _colorB.value -= multiplayer
        }
    }

    fun addG(multiplayer: Int) = viewModelScope.launch {
        if ((_colorG.value + multiplayer) <= 250) {
            _colorG.value += multiplayer
        }
    }

    fun subG(multiplayer: Int) = viewModelScope.launch {
        if ((_colorG.value - multiplayer) >= 0) {
            _colorG.value -= multiplayer
        }
    }
}