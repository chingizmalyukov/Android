package com.example.userprofile

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.user_name_text)
        val phone = findViewById<EditText>(R.id.phone_number_text)
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)
        val switch: SwitchMaterial = findViewById(R.id.switch_notifications)
        val checkBoxOne: MaterialCheckBox = findViewById(R.id.checkbox_one)
        val checkBoxTwo: MaterialCheckBox = findViewById(R.id.checkbox_two)
        val progressIndicator: LinearProgressIndicator = findViewById(R.id.progress_bar)
        val countPoints: TextView = findViewById(R.id.count_point)
        val progressCount = Random.nextInt(101)
        val saveButton = findViewById<Button>(R.id.save_button)

        var nameTrigger = false
        var phoneTrigger = false
        var radioGroupTrigger = false
        var notificationTrigger = true
        var checkBoxOneStatus = false
        var checkBoxTwoStatus = false

        fun allReadyCheck(
            nameTrigger: Boolean,
            phoneTrigger: Boolean,
            radioGroupTrigger: Boolean,
            notificationTrigger: Boolean
        ) {
            saveButton.isEnabled =
                (nameTrigger) && (phoneTrigger) && (radioGroupTrigger) && (notificationTrigger)
        }

        fun nameCheckFun(text: CharSequence?, count: Int) {
            nameTrigger = if (text != null) {
                text.isNotBlank() && count <= 40
            } else {
                false
            }
        }

        fun phoneCheckFun(text: CharSequence?) {
            phoneTrigger = text?.isNotBlank() ?: false
        }

        fun change(status: Boolean) {
            checkBoxOne.isEnabled = status
            checkBoxTwo.isEnabled = status
        }

        fun notificationTriggerStatusChange() {
            notificationTrigger = checkBoxOneStatus == true || checkBoxTwoStatus == true
        }

        name.doOnTextChanged { text, _, _, count ->
            nameCheckFun(text, count)
            allReadyCheck(nameTrigger, phoneTrigger, radioGroupTrigger, notificationTrigger)
        }

        phone.doOnTextChanged { text, _, _, _ ->
            phoneCheckFun(text)
            allReadyCheck(nameTrigger, phoneTrigger, radioGroupTrigger, notificationTrigger)
        }

        radioGroup.setOnCheckedChangeListener { _, _ ->
            radioGroupTrigger = true
            allReadyCheck(nameTrigger, phoneTrigger, true, notificationTrigger)
        }

        switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                notificationTrigger = false
                change(true)
            } else {
                notificationTrigger = true
                checkBoxOne.isChecked = false
                checkBoxTwo.isChecked = false
                change(false)

            }
            allReadyCheck(nameTrigger, phoneTrigger, radioGroupTrigger, notificationTrigger)
        }

        checkBoxOne.setOnCheckedChangeListener { _, isChecked ->
            checkBoxOneStatus = isChecked
            notificationTriggerStatusChange()
            allReadyCheck(nameTrigger, phoneTrigger, radioGroupTrigger, notificationTrigger)
        }

        checkBoxTwo.setOnCheckedChangeListener { _, isChecked ->
            checkBoxTwoStatus = isChecked
            notificationTriggerStatusChange()
            allReadyCheck(nameTrigger, phoneTrigger, radioGroupTrigger, notificationTrigger)
        }

        countPoints.text = "${progressCount}/100"
        progressIndicator.progress = progressCount

        saveButton.setOnClickListener {
            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
        }
    }
}

