package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var counter = 0
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textView.text = counter.toString()

        binding.plusOneButton.setOnClickListener {
            if (counter == 5) {
                counter = 0
                binding.button.visibility = View.VISIBLE
            } else {
                counter++
                binding.textView.text = counter.toString()
            }
        }

        binding.button.setOnClickListener {
            binding.textView.text = getString(R.string.app_name)
            binding.plusOneButton.isEnabled = false
        }
    }
}