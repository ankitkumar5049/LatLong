package com.example.location

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    private lateinit var scrollView: ScrollView
    private lateinit var acceptCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        scrollView = findViewById(R.id.scrollView)
        acceptCheckBox = findViewById(R.id.acceptCheckBox)

        val termsText = getString(R.string.terms_and_conditions)
        val termsTextView = findViewById<TextView>(R.id.termsTextView)
        termsTextView.text = termsText

        scrollView.setOnScrollChangeListener { _: View?, _: Int, _: Int, _: Int, _: Int ->
            if (scrollView.getChildAt(0).bottom <= (scrollView.height + scrollView.scrollY)) {
                acceptCheckBox.isEnabled = true
                acceptCheckBox.setTextColor(resources.getColor(R.color.black))
            }

        }
    }
    fun onAcceptClicked(view: View) {
        if (acceptCheckBox.isChecked) {
            // User has accepted the terms and conditions
            Toast.makeText(this,"Accepted",Toast.LENGTH_SHORT).show()
        } else {
            // User has not accepted the terms and conditions
            Toast.makeText(this,"Not accepted",Toast.LENGTH_SHORT).show()

        }
    }
}