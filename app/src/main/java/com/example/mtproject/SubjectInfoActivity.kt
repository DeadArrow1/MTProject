package com.example.mtproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mtproject.databinding.ActivitySubjectinfoBinding
import com.example.mtproject.model.CustomAdapter
class SubjectInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubjectinfoBinding
    private lateinit var viewModel: SubjectInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subjectinfo)

        binding = ActivitySubjectinfoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val app = application as MyApplication
        viewModel = ViewModelProvider(this, SubjectInfoViewModelFactory(app.repository))
            .get(SubjectInfoViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this



        viewModel.patchValue.observe(this) {
//            binding.txtLabel.text = it.name.plus(" - ").plus(it.description);
//            Glide.with(this).load(it.image).into(binding.imageView)

            //val arrayAdapter: ArrayAdapter<Patch> = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,it)
            binding.CustomListView.isClickable = true





            binding.CustomListView.adapter=CustomAdapter(this, arrayListOf(it))
            binding.CustomListView.setOnItemClickListener{parent, view,position,id ->
                val name = it.name
                val image = it.image
                val description = it.description
                val rarityName = it.rarityName
                val rarityColor = it.rarityColor


                val i = Intent(this,PatchActivity::class.java)
                i.putExtra("name",name)
                i.putExtra("image",image)
                i.putExtra("description",description)
                i.putExtra("rarityName",rarityName)
                i.putExtra("rarityColor",rarityColor)
                startActivity(i)

            }


        }
        viewModel.fetchPatchesFromRepository()

    }
}