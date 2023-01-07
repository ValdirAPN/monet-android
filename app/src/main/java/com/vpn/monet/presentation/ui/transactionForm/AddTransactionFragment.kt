package com.vpn.monet.presentation.ui.transactionForm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vpn.monet.R
import com.vpn.monet.databinding.FragmentAddTransactionBinding

class AddTransactionFragment : Fragment() {

    private var _binding: FragmentAddTransactionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddTransactionBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.radioGroupType.setOnCheckedChangeListener { _, checkedId ->
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
    }

}