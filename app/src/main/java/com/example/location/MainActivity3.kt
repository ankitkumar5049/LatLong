package com.example.location

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        // Show the Terms and Conditions dialog
        val termsDialog = BlankFragment()
        termsDialog.show(supportFragmentManager, "TermsDialog")
    }
}