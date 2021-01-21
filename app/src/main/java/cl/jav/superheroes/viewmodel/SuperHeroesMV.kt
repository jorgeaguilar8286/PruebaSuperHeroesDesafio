package cl.jav.superheroes.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import cl.jav.superheroes.model.Repository
import cl.jav.superheroes.model.SuperHero
import cl.jav.superheroes.view.BioFragment


class SuperHeroesMV: ViewModel() {

    private val repository=Repository()
    val heroList=repository.superList


    fun getHero(superId:Int): LiveData<SuperHero> {

        return repository.getSuperHero(superId)


    }




    init{

        viewModelScope.launch {
            repository.getSuperHeroesfromApi()
        }

    }



}