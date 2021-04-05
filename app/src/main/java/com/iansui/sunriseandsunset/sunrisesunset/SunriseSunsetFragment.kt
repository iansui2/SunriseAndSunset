package com.iansui.sunriseandsunset.sunrisesunset

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.iansui.sunriseandsunset.databinding.FragmentSunriseSunsetBinding

class SunriseSunsetFragment : Fragment() {

    private val viewModel: SunriseSunsetViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSunriseSunsetBinding.inflate(inflater)

        // Allow Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        // Give binding access to the SunriseSunsetViewModel
        binding.viewModel = viewModel

        return binding.root
    }
}