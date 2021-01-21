package cl.jav.superheroes.view

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class DetailAdapter (fragment: Fragment, superId: Int): FragmentStateAdapter(fragment) {

    val id=superId
    override fun getItemCount()=4

    override fun createFragment(position: Int): Fragment {
        var fragment=Fragment()
        when(position){
            0-> {fragment=PowStartFragment(id)}
            1-> {fragment=AparienciaFragment(id)}
            2-> {fragment=BioFragment(id)}
            3-> {fragment=OtherFragment(id)}
        }
        return fragment
    }
}