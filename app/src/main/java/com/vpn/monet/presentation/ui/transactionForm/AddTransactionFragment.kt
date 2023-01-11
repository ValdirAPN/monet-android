package com.vpn.monet.presentation.ui.transactionForm

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.vpn.monet.R
import com.vpn.monet.databinding.FragmentAddTransactionBinding
import com.vpn.monet.domain.models.Account
import com.vpn.monet.domain.models.Transaction
import com.vpn.monet.domain.models.enums.TransactionType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.math.log

@AndroidEntryPoint
class AddTransactionFragment : Fragment() {

    private var _binding: FragmentAddTransactionBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TransactionFormViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddTransactionBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupListeners()
    }

    private fun setupListeners() {
        binding.radioGroupType.setOnCheckedChangeListener { _, checkedId ->
            handleSelectedTransactionType(checkedId)
        }

        binding.textInputValue.editText?.setOnFocusChangeListener { _, receivedFocus ->
            if (receivedFocus.not()) {
                updateInstallmentsValues()
            }
        }

        binding.buttonAdd.setOnClickListener {
            saveToDatabase()
        }
    }

    private fun handleSelectedTransactionType(checkedId: Int) {
        when (checkedId) {
            R.id.radioButtonOutcome -> {
                binding.containerSender.visibility = View.GONE
                binding.containerReceiver.visibility = View.VISIBLE
            }
            else -> {
                binding.containerSender.visibility = View.VISIBLE
                binding.containerReceiver.visibility = View.GONE
            }
        }
    }

    private fun saveToDatabase() {
        val title = binding.textInputTitle.editText?.text.toString()
        val selectedRadioButton = binding.radioGroupType.checkedRadioButtonId
        val type = view?.findViewById<RadioButton>(selectedRadioButton)?.text.toString().uppercase()
        val thirdPerson = if (TransactionType.valueOf(type) == TransactionType.INCOME) {
            binding.textInputSender.editText?.text.toString()
        } else {
            binding.textInputReceiver.editText?.text.toString()
        }
        val value = binding.textInputValue.editText?.text.toString().toDouble()
        val installments =
            binding.textInputInstallments.editText?.text.toString().split("x").first().toString()
                .toInt()
        val account = binding.textInputAccount.editText?.text.toString()

        val transaction = Transaction(
            title = title,
            type = TransactionType.valueOf(type),
            thirdPerson = thirdPerson,
            value = value,
            installments = installments,
            account = Account(name = account),
            date = Date()
        )

        Log.d("AddTransactionForm", transaction.toString())

        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.createTransaction(transaction)
        }
    }

    private fun updateInstallmentsValues() {
        val value = binding.textInputValue.editText?.text.toString()

        if (value.isNotEmpty()) {
            val installmentsList = mutableListOf<String>()
            for (i in 1..12) {
                installmentsList.add("${i}x de R$ ${value.toDouble() / i}")
            }
            (binding.autoCompleteTextViewInstallments as MaterialAutoCompleteTextView)
                .setSimpleItems(installmentsList.toTypedArray())

            binding.autoCompleteTextViewInstallments.setText(installmentsList.first(), false)
        }
    }

}