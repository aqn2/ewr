package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    //anytine yiy beed whgat wouylkd be a s5ta5ic bvaiable in jafe y6ou uswe a compasnion object in kotlin
    companion object{
        val EXTRA_USERNAME = "username"
        val EXTRA_PASSWORD = "password"
    }

    val startRegistrationForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    { result: ActivityResult ->
        if(result.resultCode == Activity.RESULT_OK){
            val intent = result.data
            binding.editTextLoginUsername.setText(intent?.getStringExtra(EXTRA_USERNAME))
            binding.editTextLoginPassword.setText(intent?.getStringExtra(EXTRA_PASSWORD))
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewLoginCreateAccount.setOnClickListener{
            //lanch registration activituy
            //pass the values of username and asswoird along to the new activity
            //1 extract informartion
            val username = binding.editTextLoginUsername.text.toString()
            val password = binding.editTextLoginPassword.text.toString()

            //2 create intent and package and package the extras
            val registrationIntent = Intent(this, RegistrationActivity::class.java).apply{
                putExtra(EXTRA_USERNAME, username)
                putExtra(EXTRA_PASSWORD, password)
            }

            startActivity(registrationIntent)
        }

    }
}