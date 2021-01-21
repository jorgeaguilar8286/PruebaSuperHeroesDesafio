package cl.jav.superheroes.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import cl.jav.superheroes.databinding.FragmentDetailBinding
import com.google.android.material.tabs.TabLayoutMediator
import cl.jav.superheroes.viewmodel.SuperHeroesMV
import coil.load

class DetailFragment (id:Int): Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val viewModel:SuperHeroesMV by viewModels()
    private val superId=id

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentDetailBinding.inflate(layoutInflater)

        viewModel.getHero(superId).observe(viewLifecycleOwner,{
            binding.texvNameDetail.text=it.name
            binding.ivHeroImageLarge.load(it.images.md)
            binding.texvAlingmentDetail.text=it.biography.alignment.toUpperCase()
            binding.texvPublisher.text=it.biography.publisher
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val detailAdapter=DetailAdapter(this,superId)
        binding.detailTabs.adapter=detailAdapter
        TabLayoutMediator(binding.tabDetailHero,binding.detailTabs){tab,position->
            when(position){
                0->tab.text="Power Stats"
                1->tab.text="Appear"
                2->tab.text="Bio"
                3->tab.text="Other"
            }
        }.attach()

    }
}