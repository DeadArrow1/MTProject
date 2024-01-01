package com.example.mtproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.mtproject.databinding.ActivityPatchBinding
import com.example.mtproject.databinding.ActivitySubjectinfoBinding

class PatchActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPatchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name= intent.getStringExtra("name")
        val image= intent.getStringExtra("image")
        val description= intent.getStringExtra("description")

        Glide.with(this).load(image).into(binding.PatchImage)
        binding.PatchName.text=name
        binding.PatchDescription.text=description

    }
}