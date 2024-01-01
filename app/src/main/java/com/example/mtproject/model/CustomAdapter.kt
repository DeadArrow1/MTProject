package com.example.mtproject.model

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.mtproject.R
import com.example.mtproject.SubjectInfoActivity
import com.example.mtproject.databinding.ActivitySubjectinfoBinding

class CustomAdapter (private val context: Activity,private val arrayList: ArrayList<Patch>) : ArrayAdapter<Patch>(context,
    R.layout.patch_layout,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater:LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.patch_layout,null)


        val imageView: ImageView = view.findViewById(R.id.image)
        val name: TextView = view.findViewById(R.id.PatchName)
        val description: TextView = view.findViewById(R.id.Description)

        Glide.with(context).load(arrayList[position].image).into(imageView)
        name.text = arrayList[position].name
        description.text = arrayList[position].description


        return view
    }
}