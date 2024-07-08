package com.murside.hesapmakinesi

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.murside.hesapmakinesi.databinding.ActivityMainBinding

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
    }
    fun topla(view: View){


        val girdisayi1=binding.editText1.text.toString()
        val girdisayi2=binding.editText2.text.toString()
        if(girdisayi1.isNotEmpty()&& girdisayi2.isNotEmpty()){
            val sayi1=girdisayi1.toDoubleOrNull()
            val sayi2=girdisayi2.toDoubleOrNull()

        if(sayi1!=null && sayi2!=null ) {
            val sonuc = sayi1 / sayi2
            binding.textView.text = "sonuc ${sonuc}"
        }
        else{
            val alert= AlertDialog.Builder(this@MainActivity)
            alert.setMessage("geçerli sayi gir")
            alert.show()
        }}
        else{
            val alert2=AlertDialog.Builder(this@MainActivity)
            alert2.setMessage("boş bırakılamaz")
            alert2.show()
        }
    }

    fun cikar(view:View){
        val girdisayi1=binding.editText1.text.toString()
        val girdisayi2=binding.editText2.text.toString()

        if(girdisayi1.isNotEmpty()&&girdisayi2.isNotEmpty()){
            val sayi1=girdisayi1.toDoubleOrNull()
            val sayi2=girdisayi2.toDoubleOrNull()

            if(sayi1!=null&& sayi2!=null){
                val sonuc=sayi1*sayi2
                binding.textView.text="sonuc: ${sonuc}"
            }
            else{
                val alert1=AlertDialog.Builder(this@MainActivity
                )
                alert1.setMessage("sayi gir")
                alert1.show()
            }
        }
        else{
            val alert2=AlertDialog.Builder(this@MainActivity)
            alert2.setMessage("boş bırakmaa")
            alert2.show()
        }
    }
}