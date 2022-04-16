package com.imadev.laundryapp.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.imadev.laundryapp.R
import com.imadev.laundryapp.databinding.FragmentMainBinding
import com.imadev.laundryapp.factory.CategoriesFactory
import com.imadev.laundryapp.ui.adapter.CategoryAdapter
import com.imadev.laundryapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

private const val TAG = "MainFragment"

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val topLeftAnimationForward =
            AnimatedVectorDrawableCompat.create(
                requireContext(),
                R.drawable.top_left_liquid_forward
            )

        binding.fluidTopLeft.apply {
            setImageDrawable(topLeftAnimationForward)
        }


        val adapter = CategoryAdapter(CategoriesFactory.categoryResponse())
        binding.categoryList.adapter = adapter

        viewModel.getCategories()

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.getCategories().collect {
                val data = it.data
                when (it) {
                    is Resource.Loading -> {
                        Log.d(TAG, "Loading...")
                    }
                    is Resource.Error -> {
                        Log.d(TAG, "onViewCreated: ${it.error?.message}")
                    }
                    is Resource.Success -> {

                        Log.d(TAG, "Success $data")
                    }
                }
            }
        }
    }

}