package cl.jav.superheroes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import cl.jav.superheroes.databinding.FragmentOtherBinding
import cl.jav.superheroes.viewmodel.SuperHeroesMV

class OtherFragment (id:Int): Fragment() {
    private lateinit var binding: FragmentOtherBinding
    private val viewModel: SuperHeroesMV by viewModels()
    private val superId=id

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentOtherBinding.inflate(layoutInflater)
        viewModel.getHero(superId).observe(viewLifecycleOwner, {
            binding.tvWorkValue.text=it.work.occupation
            binding.tvBaseValue.text=it.work.base
            binding.tvGroupAffilValue.text=it.connections.groupAffiliation
            binding.tvRelativesValue.text=it.connections.relatives
        })


        return binding.root
    }
}