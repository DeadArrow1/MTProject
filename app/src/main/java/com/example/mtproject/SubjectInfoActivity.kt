package com.example.mtproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.mtproject.databinding.ActivitySubjectinfoBinding
import com.example.mtproject.model.CustomAdapter
import com.example.mtproject.model.Patch

class SubjectInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubjectinfoBinding
    private lateinit var viewModel: SubjectInfoViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)



        viewModel = ViewModelProvider(this)[SubjectInfoViewModel::class.java]



        viewModel.patchLiveData.observe(this) {
//            binding.txtLabel.text = it.name.plus(" - ").plus(it.description);
//            Glide.with(this).load(it.image).into(binding.imageView)

            //val arrayAdapter: ArrayAdapter<Patch> = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,it)
            binding.CustomListView.adapter=CustomAdapter(this,it)


        }
        viewModel.fetchPatchesFromRepository()

    }
}