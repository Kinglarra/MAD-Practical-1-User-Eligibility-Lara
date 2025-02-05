package com.example.king
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.king.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val ageEditText: EditText = findViewById(R.id.ageEditText)
        val genderSpinner: Spinner = findViewById(R.id.genderSpinner)
        val checkButton: Button = findViewById(R.id.checkButton)
        val resetButton: Button = findViewById(R.id.resetButton)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        val genderOptions = arrayOf("Select Gender", "Male", "Female", "Other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genderOptions)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpinner.adapter = adapter


        checkButton.setOnClickListener {
            val name = nameEditText.text.toString().trim()
            val ageText = ageEditText.text.toString().trim()
            val gender = genderSpinner.selectedItem.toString()

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(ageText) || gender == "Select Gender") {
                resultTextView.text = "Please fill in all fields."
                resultTextView.setTextColor(resources.getColor(R.color.red))
                return@setOnClickListener
            }

            val age = ageText.toIntOrNull()
            if (age == null || age < 0) {
                resultTextView.text = "Please enter a valid age."
                resultTextView.setTextColor(resources.getColor(R.color.red))
                return@setOnClickListener
            }

            if (age >= 18) {
                resultTextView.text = "Hello $name! You are eligible to drink alcohol in the Philippines."
                resultTextView.setTextColor(resources.getColor(R.color.green))
            } else {
                resultTextView.text = "Hello $name! You are NOT eligible to drink alcohol in the Philippines."
                resultTextView.setTextColor(resources.getColor(R.color.red))
            }
        }


        resetButton.setOnClickListener {
            nameEditText.text.clear()
            ageEditText.text.clear()
            genderSpinner.setSelection(0)
            resultTextView.text = ""
        }
    }
}















        






















