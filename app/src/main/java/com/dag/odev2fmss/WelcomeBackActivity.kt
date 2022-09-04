package com.dag.odev2fmss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.dag.odev2fmss.databinding.ActivityWelcomeBackBinding

class WelcomeBackActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBackBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_back)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome_back)
        launcher()

    }

    private fun launcher(){
        //binding.welcomebackUsername.background.setTint(ContextCompat.getColor(this, R.color.error))
        binding.backIcon.setOnClickListener {
            val intent = Intent(this, GetStartedActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent)
        }

        binding.createAccount.setOnClickListener{
            val intent = Intent(this, CreateAccountActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent)
        }

        binding.welcomebackLogin.setOnClickListener(View.OnClickListener {
            val username = binding.welcomebackUsername.text
            val password = binding.welcomebackPassword.text

            val isUserNameEmpty = username.isEmpty()
            val isPasswordEmpty = password.isEmpty()

            if (isUserNameEmpty){
                binding.welcomebackUsername.background.setTint(ContextCompat.getColor(this, R.color.error))
            }else{
                binding.welcomebackUsername.background.setTint(ContextCompat.getColor(this, R.color.black))
            }

            if(isPasswordEmpty){
                binding.welcomebackPassword.background.setTint(ContextCompat.getColor(this, R.color.error))
            }else{
                binding.welcomebackPassword.background.setTint(ContextCompat.getColor(this, R.color.black))
            }

            if(isPasswordEmpty || isUserNameEmpty){
                Toast.makeText(this,"Username and Password not be empty", Toast.LENGTH_LONG).show()
            }else{
                if (username.toString().equals(User.USERNAME) && password.toString().equals(User.PASSWORD)){
                    Toast.makeText(this, "Welcome back $username", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, "This user not exist", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }


}