package com.murside.superkahramanlar

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.murside.superkahramanlar.databinding.ActivityMain2Binding
import com.murside.superkahramanlar.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding:ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //val adapterdengelenintent=intent
        var secilenKahraman=MySingelton.secilensuperKahraman
        //guncel telefonlarda val secilenKahraman=adapterdengelenintent.getSerializableExtra("secilenKahraman",superKahraman::class.java)
       //val secilenKahraman=adapterdengelenintent.getSerializableExtra("secilenKahraman") as superKahraman

        secilenKahraman?.let{
            binding.imageView2.setImageResource(secilenKahraman.resim)
            binding.isim.text=secilenKahraman.isim
            binding.meslek.text=secilenKahraman.meslek
        }

        

    }
}