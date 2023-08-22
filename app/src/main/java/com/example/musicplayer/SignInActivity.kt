package com.example.musicplayer

import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

// SignInActivity.kt
class SignInActivity : AppCompatActivity() {
    // Initialize Firebase Auth
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    // Handle sign in button click
    private fun signIn() {
        val email = "user@example.com"
        val password = "password"

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, navigate to main activity
                } else {
                    // Sign in failed, display error message
                }
            }
    }
}