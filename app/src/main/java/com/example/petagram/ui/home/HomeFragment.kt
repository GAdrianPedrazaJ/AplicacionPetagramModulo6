package com.example.petagram.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petagram.data.Mascota
import com.example.petagram.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MascotaAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val data = listOf(
            Mascota(1, "Catty", 5, com.example.petagram.R.drawable.ic_pet_sample),
            Mascota(2, "Ronny", 3, com.example.petagram.R.drawable.ic_pet_sample),
            Mascota(3, "Buddy", 4, com.example.petagram.R.drawable.ic_pet_sample)
        )
        adapter = MascotaAdapter(data)
        binding.rvMascotas.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMascotas.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
