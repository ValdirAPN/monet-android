package com.vpn.monet.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vpn.monet.data.mocks.TRANSCATIONS_MOCK
import com.vpn.monet.domain.models.Transaction
import com.vpn.monet.domain.usecases.GetTransactionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeUiState(
    val totalBalance: Double = 0.0,
    val totalExpenses: Double = 0.0,
    val transactionsHistoryList: List<Transaction> = listOf()
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTransactionsUseCase: GetTransactionsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        refreshHistory()
    }

    private fun refreshHistory() {
        viewModelScope.launch {
            val transactionsFlow = getTransactionsUseCase.invoke()

            transactionsFlow.collect { transactions ->
                _uiState.update { currentState ->
                    currentState.copy(
                        transactionsHistoryList = transactions
                    )
                }
            }
        }
    }
}