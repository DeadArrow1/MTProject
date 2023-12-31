package com.example.mtproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mtproject.databinding.ActivityDetailBinding
import com.example.mtproject.databinding.ActivitySubjectinfoBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val zkratka = intent.getStringExtra("MYDATA")

        binding.textZkratka.text = zkratka.toString()


    }
}