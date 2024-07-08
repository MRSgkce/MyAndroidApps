package com.murside.mesajlar

import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.murside.mesajlar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var sharedPreferences: SharedPreferences
   var alinankullaniciadi:String?= null
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


        sharedPreferences=this.getSharedPreferences("com.murside.mesajlar", MODE_PRIVATE)
        alinankullaniciadi=sharedPreferences.getString("isim","")
        if(alinankullaniciadi=="") {
            binding.textView.text = "kayıtli isim"
        }else{
            binding.textView.text="kaydedilen isim: ${alinankullaniciadi}"
        }

    }
    fun kaydet(view: View){
    val girdiisim=binding.editText.text.toString()
        if(girdiisim=="isim"){
            Toast.makeText(this@MainActivity,"ismini boş bırakmayın",Toast.LENGTH_LONG).show()

        }else{
            sharedPreferences.edit().putString("isim",girdiisim).apply()
            binding.textView.text="kaydedilen isim: ${girdiisim}"
        }



    }

    fun sil (view:View){

    }
}