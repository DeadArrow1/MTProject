package com.example.mtproject.model

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.mtproject.DB.RoomDB.PatchDTO
import com.example.mtproject.Domain.PatchDomain
import com.example.mtproject.R

class CustomAdapter(private val context: Activity, private val arrayList: Array<PatchDTO>) : ArrayAdapter<PatchDTO>(context,
    R.layout.patch_layout,arrayList) {




    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater:LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.patch_layout,null)


        val imageView: ImageView = view.findViewById(R.id.image)
        val name: TextView = view.findViewById(R.id.PatchName)
        val description: TextView = view.findViewById(R.id.Description)
        val PatchImageBackground: FrameLayout = view.findViewById(R.id.PatchImageBackground)

        Glide.with(context).load(arrayList[position].image).into(imageView)
        name.text = arrayList[position].name
        description.text = arrayList[position].description

        val gd = GradientDrawable(
            GradientDrawable.Orientation.TL_BR,
            intArrayOf(android.R.color.background_dark, Color.parseColor(arrayList[position].rarityColor), Color.WHITE)
        )
        gd.gradientType = GradientDrawable.RADIAL_GRADIENT
        gd.gradientRadius = 180.0f
        gd.setGradientCenter(0.5f, 0.5f)
        PatchImageBackground.background = gd


        return view
    }


}