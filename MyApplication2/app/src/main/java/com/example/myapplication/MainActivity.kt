package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var counter = 0

        binding.textView.text = counter.toString()

        binding.plusOneButton.setOnClickListener {
            if (counter == 5) {
                counter = 0
                binding.mainButton.visibility = View.VISIBLE
            } else {
                counter++
                binding.textView.text = counter.toString()
            }
        }

        binding.mainButton.setOnClickListener {
            binding.textView.text = getString(R.string.app_name)
            binding.plusOneButton.isEnabled = false
        }

    }
}
