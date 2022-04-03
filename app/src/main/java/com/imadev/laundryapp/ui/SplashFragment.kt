package com.imadev.laundryapp.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.imadev.laundryapp.R
import com.imadev.laundryapp.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        makeAnimatedWave()

        binding.getStarted.setOnClickListener {
            val action = SplashFragmentDirections.actionSplashFragmentToMainFragment()
            findNavController().navigate(action)

        }

    }

    private fun makeAnimatedWave() {
        val topLeftAnimationForward =
            AnimatedVectorDrawableCompat.create(
                requireContext(),
                R.drawable.top_left_liquid_forward
            )
        val topLeftAnimationReverse =
            AnimatedVectorDrawableCompat.create(
                requireContext(),
                R.drawable.top_left_liquid_reverse
            )

        val bottomRightAnimationForward =
            AnimatedVectorDrawableCompat.create(
                requireContext(),
                R.drawable.bottom_right_liquid_forward
            )
        val bottomRightAnimationReverse =
            AnimatedVectorDrawableCompat.create(
                requireContext(),
                R.drawable.bottom_right_liquid_reverse
            )


        val topLeftImageView = binding.fluidTopLeft.apply {
            setImageDrawable(topLeftAnimationForward)
        }
        val bottomRightImageView = binding.fluidBottomRight.apply {
            setImageDrawable(bottomRightAnimationForward)
        }

        topLeftAnimationForward?.registerAnimationCallback(object :
            Animatable2Compat.AnimationCallback() {
            override fun onAnimationEnd(drawable: Drawable?) {
                topLeftImageView.setImageDrawable(topLeftAnimationReverse)
                topLeftAnimationReverse?.start()

            }
        })
        topLeftAnimationReverse?.registerAnimationCallback(object :
            Animatable2Compat.AnimationCallback() {
            override fun onAnimationEnd(drawable: Drawable?) {
                topLeftImageView.setImageDrawable(topLeftAnimationForward)
                topLeftAnimationForward?.start()
            }
        })

        bottomRightAnimationForward?.registerAnimationCallback(object :
            Animatable2Compat.AnimationCallback() {
            override fun onAnimationEnd(drawable: Drawable?) {
                bottomRightImageView.setImageDrawable(bottomRightAnimationReverse)
                bottomRightAnimationReverse?.start()
            }
        })
        bottomRightAnimationReverse?.registerAnimationCallback(object :
            Animatable2Compat.AnimationCallback() {
            override fun onAnimationEnd(drawable: Drawable?) {
                bottomRightImageView.setImageDrawable(bottomRightAnimationForward)
                bottomRightAnimationForward?.start()
            }
        })

        topLeftAnimationForward?.start()
        bottomRightAnimationForward?.start()
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}