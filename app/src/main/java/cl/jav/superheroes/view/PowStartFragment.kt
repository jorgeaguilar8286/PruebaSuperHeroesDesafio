package cl.jav.superheroes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import cl.jav.superheroes.databinding.FragmentPowStartBinding
import cl.jav.superheroes.viewmodel.SuperHeroesMV


class PowStartFragment(id:Int): Fragment() {
    private lateinit var binding: FragmentPowStartBinding
    private val viewModel:SuperHeroesMV by viewModels()
    private val superId=id

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentPowStartBinding.inflate(layoutInflater)
        viewModel.getHero(superId).observe(viewLifecycleOwner, {
            binding.texvIntelLa.text = "Intellingence:  ".plus(it.powerstats.intelligence.toString())
            binding.texvStrenLa.text = "Strength        :   ".plus(it.powerstats.strength.toString())
            binding.texvSpeLa.text = "Speed            :    ".plus(it.powerstats.speed.toString())
            binding.texvDuraLa.text = "Durability      :   ".plus(it.powerstats.durability.toString())
            binding.texvPowLa.text = "Power            :    ".plus(it.powerstats.power.toString())
            binding.texvComLa.text = "Combat          :    ".plus(it.powerstats.combat.toString())
        })

        return binding.root
    }


}