package com.enigmacamp.customerfeature.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.enigmacamp.core.presentation.ViewModelFactoryBase
import com.enigmacamp.customerfeature.R
import com.enigmacamp.customerfeature.databinding.FragmentCustomerBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class CustomerFragment : DaggerFragment() {
    private lateinit var binding: FragmentCustomerBinding

    @Inject
    lateinit var viewModel: CustomerFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        subscribe()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCustomerBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactoryBase {
            viewModel
        }).get(CustomerFragmentViewModel::class.java)
    }

    private fun subscribe() {
        viewModel.customerLiveData.observe(this, {
            binding.idCardTextView.text = it.idCard
            binding.nameTextView.text = it.name
        })
    }

    companion object {

        @JvmStatic
        fun newInstance() = CustomerFragment()
    }
}