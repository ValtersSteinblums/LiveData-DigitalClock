package com.example.livedataindetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.livedataindetail.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clickMeButton.setOnClickListener {
            viewModel.onButtonClicked()
        }

        viewModel.segmentStateLiveData.observe(this) {
            binding.segment.root.apply {
                val resolvedColor = ContextCompat.getColor(context, it)
                setCardBackgroundColor(resolvedColor)
            }
        }
    }


}