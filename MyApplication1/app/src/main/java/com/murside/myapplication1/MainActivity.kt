package com.murside.myapplication1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.murside.myapplication1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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

/*
        binding.textView.text="merhaba murside"
        binding.button.setOnClickListener{
            binding.textView.text="butone tıkladı"
*/
        }

    override fun onStart() {
        super.onStart()
        println("onstart çalıştı")

    }

    override fun onResume() {
        super.onResume()
        println("onresume çalıştı")
    }

    override fun onPause() {
        super.onPause()
        println("onpause çalıştı")
    }

    override fun onStop() {
        super.onStop()
        println("onstop çalıştı")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("ondestroy çalıştı")
    }

    fun sonrakiSayfa(view:View){
        val intent=Intent(this,MainActivity2::class.java)
        val girdi=binding.editText1.text.toString()
        intent.putExtra("isim",girdi)
        startActivity(intent)
    }

    }






