package com.example.rbg.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RBGViewModel : ViewModel() {
    private val _colorR: MutableStateFlow<Int> = MutableStateFlow(0)
    private val _colorB: MutableStateFlow<Int> = MutableStateFlow(0)
    private val _colorG: MutableStateFlow<Int> = MutableStateFlow(0)
    val colorR = _colorR.asStateFlow()
    val colorB = _colorB.asStateFlow()
    val colorG = _colorG.asStateFlow()

    fun addR(multiplayer: Int) = viewModelScope.launch {
        val value = multiplayer + 1
        if ((_colorR.value + value) <= 250) {
            _colorR.value += value
        }
        Log.d("TAG", "addR: ${colorR.value}")
    }

    fun subR(multiplayer: Int) = viewModelScope.launch {
        val value = multiplayer - 1
        if ((_colorR.value - value) >= 0) {
            _colorR.value -= value
        }
    }

    fun addB(multiplayer: Int) = viewModelScope.launch {
        val value = multiplayer + 1
        if ((_colorB.value + value) <= 250) {
            _colorB.value += value
        }
    }

    fun subB(multiplayer: Int) = viewModelScope.launch {
        val value = multiplayer - 1
        if ((_colorB.value - value) >= 0) {
            _colorB.value -= value
        }
    }

    fun addG(multiplayer: Int) = viewModelScope.launch {
        val value = multiplayer + 1
        if ((_colorG.value + value) <= 250) {
            _colorG.value += value
        }
    }

    fun subG(multiplayer: Int) = viewModelScope.launch {
        val value = multiplayer - 1
        if ((_colorG.value - value) >= 0) {
            _colorG.value -= value
        }
    }
}