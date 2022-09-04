package com.dag.odev2fmss

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.dag.odev2fmss.databinding.ActivityWelcomeBackBinding

class WelcomeBackActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBackBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_back)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome_back)

        binding.createAccount.setOnClickListener(View.OnClickListener {

            if(true){
                val intent = Intent(this, CreateAccountActivity::class.java)
                startActivity(intent)
            }
        })
    }



    // function which checks all the text fields
    // are filled or not by the user.
    // when user clicks on the SIGN IN button
    // this function is triggered.


}