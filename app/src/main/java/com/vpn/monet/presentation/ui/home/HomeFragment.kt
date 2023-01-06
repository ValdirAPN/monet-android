package com.vpn.monet.presentation.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.vpn.monet.R
import com.vpn.monet.data.mocks.TRANSCATIONS_MOCK
import com.vpn.monet.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TransactionsHistoryAdapter(TRANSCATIONS_MOCK)
        binding.recyclerViewHistory.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}