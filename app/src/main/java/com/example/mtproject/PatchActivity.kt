package com.example.mtproject

import android.R
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.GradientDrawable.RADIAL_GRADIENT
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mtproject.databinding.ActivityPatchBinding


class PatchActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPatchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPatchBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val name= intent.getStringExtra("name")?.replace("Patch | ","")
        val image= intent.getStringExtra("image")
        val description= intent.getStringExtra("description")?.replace("<i>","")?.replace("</i>","")

        val rarityName= intent.getStringExtra("rarityName")
        val rarityColor= intent.getStringExtra("rarityColor")




        Glide.with(this).load(image).into(binding.PatchImage)
        binding.PatchName.text=name


        binding.PatchDescription.text=description


        binding.RarityName.text=rarityName
        binding.RarityName.setTextColor(Color.parseColor(rarityColor))



        val gd = GradientDrawable(GradientDrawable.Orientation.TL_BR,
            intArrayOf(R.color.background_dark, Color.parseColor(rarityColor), Color.WHITE)
        )
        gd.gradientType = RADIAL_GRADIENT
        gd.gradientRadius = 500.0f
        gd.setGradientCenter(0.5f, 0.5f)
        binding.PatchImageBackground.background = gd



    }


}