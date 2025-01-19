package com.example.islami

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.islami.databinding.ActivityHomeBinding
import com.example.islami.fragments.HadithFragment
import com.example.islami.fragments.QuranFragment
import com.example.islami.fragments.RadioFragment
import com.example.islami.fragments.SebhaFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        changeFragment(QuranFragment())

        binding.bottomNavBar.setOnItemSelectedListener {menuItem ->
            when(menuItem.itemId){
                R.id.quranNav -> changeFragment(QuranFragment())
                R.id.hadithNav -> changeFragment(HadithFragment())
                R.id.sebhaNav -> changeFragment(SebhaFragment())
                R.id.radioNav -> changeFragment(RadioFragment())
                else -> changeFragment(QuranFragment())
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment,fragment).commit()
    }
}