package com.dag.odev2fmss

import android.content.Intent
import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.dag.odev2fmss.databinding.ActivityCreateAccountBinding

class CreateAccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_account)
        launcher()
    }


    private fun launcher() {
        binding.createaccountBackIcon.setOnClickListener {
            val intent = Intent(this, WelcomeBackActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent)
        }

        binding.createaccountSignup.setOnClickListener {
            val username = binding.createaccountUsername.text
            val password = binding.createaccountPassword.text
            val email = binding.createaccountEmail.text

            val isUserNameEmpty = username.isEmpty()
            val isPasswordEmpty = password.isEmpty()
            val isEmailEmpty = email.isEmpty()

            if (isUserNameEmpty) {
                binding.createaccountUsername.background.setTint(
                    ContextCompat.getColor(
                        this,
                        R.color.error
                    )
                )
            } else {
                binding.createaccountUsername.background.setTint(
                    ContextCompat.getColor(
                        this,
                        R.color.black
                    )
                )
            }

            if (isPasswordEmpty) {
                binding.createaccountPassword.background.setTint(
                    ContextCompat.getColor(
                        this,
                        R.color.error
                    )
                )
            } else {
                binding.createaccountPassword.background.setTint(
                    ContextCompat.getColor(
                        this,
                        R.color.black
                    )
                )
            }

            if (isPasswordEmpty) {
                binding.createaccountEmail.background.setTint(
                    ContextCompat.getColor(
                        this,
                        R.color.error
                    )
                )
            } else {
                binding.createaccountEmail.background.setTint(
                    ContextCompat.getColor(
                        this,
                        R.color.black
                    )
                )
            }

            if (isPasswordEmpty || isUserNameEmpty || isEmailEmpty) {
                Toast.makeText(this, "Username, Email and Password not be empty", Toast.LENGTH_LONG)
                    .show()
            } else {
                Toast.makeText(
                    this,
                    "Username: $username, Email: $email, Password: $password",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }

    }
}