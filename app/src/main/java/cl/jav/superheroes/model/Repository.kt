package cl.jav.superheroes.model

import androidx.lifecycle.LiveData
import cl.jav.superheroes.view.BioFragment

class Repository {
    private val database=SuperApplication.superDatabase!!
    val superList= database.superDao().getAllSuper()


    suspend fun getSuperHeroesfromApi(){

        val response=RetrofitClient.retrofitClient().getSuperHeroes()

        when(response.isSuccessful){

            true -> { response.body()?.let{

                database.superDao().loadAllSuper(it)
            }}

            false-> {
            }
        }

    }

    fun getSuperHero(superId:Int):LiveData<SuperHero> {
        return database.superDao().getSuper(superId)

    }
}