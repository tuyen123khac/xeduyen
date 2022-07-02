package com.tuyenvo.xeduyen.account.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.tuyenvo.xeduyen.R
import com.tuyenvo.xeduyen.account.activities.AccountActivity
import com.tuyenvo.xeduyen.account.viewmodels.AccountViewModel
import com.tuyenvo.xeduyen.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    private val viewModel: AccountViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        setupListener()
    }

    private fun setupListener() {
        binding.backButton.setOnClickListener {
            (activity as AccountActivity).onBackPressed()
        }
    }

}