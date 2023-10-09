package com.example.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.example.viewgroup.databinding.CustomViewBinding

class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private val binding: CustomViewBinding
    init {
        val inflatedView = inflate(context, R.layout.custom_view, this)
        binding = CustomViewBinding.bind(inflatedView)

    }
    fun setUpperText(message: String) {
        binding.textOne.text = message
    }

    fun setBottomText(message: String) {
        binding.textTwo.text = message
    }
}