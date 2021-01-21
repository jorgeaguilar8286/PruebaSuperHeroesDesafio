package cl.jav.superheroes.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cl.jav.superheroes.R
import cl.jav.superheroes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        supportFragmentManager.
        beginTransaction().
        replace(R.id.fc_container, ListFragment()).
        addToBackStack("back").
        commit()


        setContentView(binding.root)




    }
}