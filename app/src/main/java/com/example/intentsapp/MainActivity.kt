package com.example.intentsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intentsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.button1.setOnClickListener() {
            var num = binding.dialEdit.text
            var link = Uri.parse("tel: $num")
            var intent = Intent(Intent.ACTION_DIAL)
            intent.setData(link)
            startActivity(intent)
        }
        binding.button2.setOnClickListener() {
            var site = binding.browserEdit.text
            var web = Uri.parse("$site")
            var intent = Intent(Intent.ACTION_VIEW)
            intent.setData(web)
            startActivity(intent)
        }
    }
}