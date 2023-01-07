package com.vpn.monet.presentation.ui.home

import androidx.lifecycle.ViewModel
import com.vpn.monet.data.mocks.TRANSCATIONS_MOCK
import com.vpn.monet.domain.models.Transaction
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class HomeUiState(
    val totalBalance: Double = 0.0,
    val totalExpenses: Double = 0.0,
    val transactionsHistoryList: List<Transaction> = listOf()
)

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        refreshHistory()
    }

    private fun refreshHistory() {
        _uiState.update { currentState ->
            currentState.copy(
                transactionsHistoryList = TRANSCATIONS_MOCK
            )
        }
    }
}