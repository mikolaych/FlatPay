package ru.mikolaych.flatpay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.mikolaych.flatpay.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportFragmentManager.beginTransaction().replace(R.id.content, FlatsFragment()).commit()
        bottomMenuActivation()

    }


                                        //Нижнее меню
    private fun bottomMenuActivation(){
        binding?.bottomMenu?.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.flats -> supportFragmentManager.beginTransaction().replace(R.id.content, FlatsFragment()).commit()
                R.id.houses -> supportFragmentManager.beginTransaction().replace(R.id.content, HouseFragment()).commit()
                R.id.notes -> supportFragmentManager.beginTransaction().replace(R.id.content, NotesFragment()).commit()

            }
            return@setOnItemSelectedListener true

        }
    }
}