package com.example.location

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class BlankFragment : DialogFragment() {

    private lateinit var webView: WebView
    private lateinit var acceptButton: Button

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_blank, null)
        webView = dialogView.findViewById(R.id.termsWebView)
        acceptButton = dialogView.findViewById(R.id.acceptButton)

        webView.loadUrl("https://en.wikipedia.org/wiki/Rahul_Gandhi")
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                // Enable accept button when the web page finishes loading
                acceptButton.isEnabled = false
                webView.setOnScrollChangeListener { _, _, _, _, _ ->
                    // Check if the user has scrolled to the bottom of the web view
                    val isScrolledToBottom = !view.canScrollVertically(1)
                    acceptButton.isEnabled = isScrolledToBottom
                }
            }
        }

        acceptButton.setOnClickListener {
            if (acceptButton.isEnabled) {
                // User has accepted the terms and conditions
                dismiss()
            }
        }

        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Terms and Conditions")
            .setView(dialogView)
            .setCancelable(false)
            .create()

        dialog.setCanceledOnTouchOutside(false)
        return dialog
    }
}
