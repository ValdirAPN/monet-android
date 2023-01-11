package com.vpn.monet.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.vpn.monet.R
import com.vpn.monet.databinding.TransactionsHistoryItemBinding
import com.vpn.monet.domain.common.utils.toCurrency
import com.vpn.monet.domain.models.Transaction
import com.vpn.monet.domain.models.enums.TransactionType

class TransactionsHistoryAdapter(
    private val dataSet: MutableList<Transaction>
) : RecyclerView.Adapter<TransactionsHistoryAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: TransactionsHistoryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Transaction) {
            binding.textViewAmount.text = item.value.toCurrency()
            binding.textViewName.text = item.title
            binding.textViewLocation.text = item.thirdPerson

            val transactionTypeImage = when (item.type) {
                TransactionType.INCOME -> ContextCompat.getDrawable(binding.root.context, R.drawable.ic_money_received)
                TransactionType.OUTCOME -> ContextCompat.getDrawable(binding.root.context, R.drawable.ic_money_sent)
            }
            binding.imageViewTransactionType.setImageDrawable(transactionTypeImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TransactionsHistoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    fun overrideAll(newDataSet: List<Transaction>) {
        dataSet.clear()
        dataSet.addAll(newDataSet)
        notifyItemRangeChanged(0, newDataSet.size)
    }
}