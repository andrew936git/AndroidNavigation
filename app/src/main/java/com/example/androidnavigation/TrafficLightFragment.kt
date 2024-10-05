package com.example.androidnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.androidnavigation.databinding.FragmentTrafficLightBinding


class TrafficLightFragment : Fragment() {

    private var _binding: FragmentTrafficLightBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrafficLightBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setTitle("Светофор")
        binding.exitIV.setOnClickListener {
            requireActivity().finishAffinity()
        }

        binding.redBT.setOnClickListener {
            val name = binding.redBT.text.toString()
            val action = TrafficLightFragmentDirections.actionTrafficLightFragmentToRedLightFragment(name)
            val extras = FragmentNavigatorExtras(binding.redBT to "redBT")
            findNavController().navigate(action, extras)

        }

        binding.yellowBT.setOnClickListener {
            val name = binding.yellowBT.text.toString()
            val action = TrafficLightFragmentDirections.actionTrafficLightFragmentToYellowLightFragment(name)
            val extras = FragmentNavigatorExtras(binding.yellowBT to "yellowBT")
            findNavController().navigate(action, extras)
        }

        binding.greenBT.setOnClickListener {
            val name = binding.greenBT.text.toString()
            val action = TrafficLightFragmentDirections.actionTrafficLightFragmentToGreenLightFragment(name)
            val extras = FragmentNavigatorExtras(binding.greenBT to "greenBT")
            findNavController().navigate(action, extras)
        }
    }


}