package com.example.pets

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.pets.databinding.FragmentAnimalBinding

class AnimalFragment : Fragment(R.layout.fragment_animal) {
    private var _binding: FragmentAnimalBinding? = null
    private val binding get() = _binding!!

    private var adapter: PetAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAnimalBinding.bind(view)

//        val text = arguments?.getString(ARG_TEXT).orEmpty()
        initAdapter()
        initPref()
    }

    private fun initAdapter() {
        adapter = PetAdapter(
            AnimalRepository.animals,
            Glide.with(this)
        ) {
            binding.root.showSnackbar("Animal id: ${it.Id}")
        }
        binding.tvTitle.setOnClickListener {
            AnimalRepository.animals.removeAt(0)
            adapter?.updateData(AnimalRepository.animals)
        }
        binding.rvAnimal.adapter = adapter
        binding.rvAnimal.layoutManager = GridLayoutManager(requireContext(), 2)

    }

    private fun initPref() {
        val pref = activity?.getSharedPreferences("TEST", Context.MODE_PRIVATE) ?: return
        val value = pref.getString("PREF_TEXT", "error").orEmpty()
        binding.root.showSnackbar(value)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val ARG_TEXT = "amazing"

        fun createBundle(text: String): Bundle {
            val bundle = Bundle()
            bundle.putString(
                ARG_TEXT,
                text
            )
            return bundle
        }
    }
}