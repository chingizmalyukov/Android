package com.example.buscounter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.buscounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var counter = 0
        binding.buttonMinus.isEnabled = false
        binding.textPassengers.text = counter.toString()

        binding.buttonPlus.setOnClickListener {
            binding.buttonMinus.isEnabled = true
            binding.textStatus.setTextColor(Color.BLUE)
            if (counter >= 49) {
                counter = 50
                binding.textReset.visibility = View.VISIBLE
                binding.buttonPlus.isEnabled = false
                binding.textStatus.text = "Too many passengers"
                binding.textStatus.setTextColor(Color.RED)
            } else {
                counter++
                binding.textStatus.text = "passenger seats left ${50 - counter}"
            }
            binding.textPassengers.text = counter.toString()
        }

        binding.buttonMinus.setOnClickListener {
            binding.textStatus.setTextColor(Color.BLUE)
            if (counter == 1) {
                counter = 0
                binding.textStatus.text = "All seats are free"
                binding.textStatus.setTextColor(Color.GREEN)
                binding.buttonMinus.isEnabled = false
            } else {
                counter -= 1
                binding.buttonPlus.isEnabled = true
                binding.textStatus.text = "passenger seats left ${50 - counter}"
            }
            binding.textPassengers.text = counter.toString()
        }

        binding.textReset.setOnClickListener {
            counter = 0
            binding.buttonMinus.isEnabled = false
            binding.buttonPlus.isEnabled = true
            binding.textReset.visibility = View.INVISIBLE
            binding.textStatus.text = "All seats are free"
            binding.textStatus.setTextColor(Color.GREEN)
            binding.textPassengers.text = counter.toString()
        }
    }
}