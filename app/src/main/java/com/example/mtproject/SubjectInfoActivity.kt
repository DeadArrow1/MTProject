package com.example.mtproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mtproject.databinding.ActivitySubjectinfoBinding

class SubjectInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubjectinfoBinding
    private lateinit var viewModel: SubjectInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubjectinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this)[SubjectInfoViewModel::class.java]



        viewModel.patchLiveData.observe(this){
            binding.txtLabel.text = it.name;
        }
        viewModel.fetchPatchesFromRepository()









    }
}