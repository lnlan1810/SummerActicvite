package com.example.pets

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pets.databinding.FragmentMain1Binding

class main1Fragment : Fragment(R.layout.fragment_main1) {
    private var _binding: FragmentMain1Binding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMain1Binding.bind(view)

        with(binding) {
            btnAnimal.setOnClickListener {

                findNavController().navigate(
                    R.id.action_main1Fragment_to_animalFragment,

                    )
            }

        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
