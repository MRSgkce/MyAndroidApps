package com.murside.superkahramanlar

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.murside.superkahramanlar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var superKahramanList: ArrayList<superKahraman>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val superman=superKahraman("superman","gazeteci",R.drawable.one)
        val batman=superKahraman("batman", "patron" ,R.drawable.two)
        superKahramanList= arrayListOf(superman,batman)
        val adapter1=Adapter(superKahramanList)
        binding.superkahramanrecycle.layoutManager=LinearLayoutManager(this)
        binding.superkahramanrecycle.adapter=adapter1

    }
}