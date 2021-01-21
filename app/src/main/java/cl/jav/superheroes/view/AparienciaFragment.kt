package cl.jav.superheroes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import cl.jav.superheroes.databinding.FragmentAparienciaBinding
import cl.jav.superheroes.viewmodel.SuperHeroesMV

class AparienciaFragment(id:Int): Fragment() {
    private lateinit var binding: FragmentAparienciaBinding
    private val viewModel: SuperHeroesMV by viewModels()
    private val superId=id

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentAparienciaBinding.inflate(layoutInflater)
        viewModel.getHero(superId).observe(viewLifecycleOwner, {
            binding.tvHeigthValue.text=it.appearance.height[1]
            binding.tvWeightValue.text=it.appearance.weight[1]
            binding.tvGenderValue.text=it.appearance.gender
            binding.tvRaceValue.text=it.appearance.race
            binding.tvEyeValue.text=it.appearance.eyeColor
            binding.tvHairValue.text=it.appearance.hairColor
        })


        return binding.root
    }
}