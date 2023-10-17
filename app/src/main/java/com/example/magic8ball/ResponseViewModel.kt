package com.example.magic8ball

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
class ResponseViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {
    private val responseBank = listOf( Response(R.string.response_0),Response(R.string.response_1),Response(R.string.response_2),
        Response(R.string.response_3), Response(R.string.response_4),
        Response(R.string.response_5), Response(R.string.response_6),
        Response(R.string.response_7), Response(R.string.response_8),
        Response(R.string.response_9), Response(R.string.response_10),
        Response(R.string.response_11), Response(R.string.response_12),
        Response(R.string.response_13), Response(R.string.response_14),
        Response(R.string.response_15), Response(R.string.response_16),
        Response(R.string.response_17), Response(R.string.response_18),
        Response(R.string.response_19),Response(R.string.response_20)
        )
    private var currentIndex: Int
        get() = savedStateHandle[CURRENT_INDEX_KEY] ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)


    val nextResponseText: Int
        get() = responseBank[currentIndex].responseText

    fun nextResponse() {
        val randomText = responseBank.random()
        currentIndex = responseBank.indexOf(randomText)
    }
}