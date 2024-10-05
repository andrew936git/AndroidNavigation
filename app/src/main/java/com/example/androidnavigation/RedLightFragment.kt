package com.example.androidnavigation

import android.os.Bundle
import android.transition.Transition
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.androidnavigation.databinding.FragmentRedLightBinding

class RedLightFragment : Fragment() {

    private var _binding: FragmentRedLightBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRedLightBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.apply {
            setTitle("Светофор")
            setNavigationIcon(R.drawable.ic_home)
            setNavigationOnClickListener {
                view.findNavController().navigate(R.id.action_redLightFragment_to_trafficLightFragment)
            }
            binding.exitIV.setOnClickListener{
                requireActivity().finishAffinity()
            }

        }

        val args: RedLightFragmentArgs by navArgs()
        val text = args.myArgs
        binding.redFragmentTV.text = text
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context)
            .inflateTransition(android.R.transition.move)

    }

}

