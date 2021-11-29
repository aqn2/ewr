package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.ActivityRegistrationBinding

private lateinit var binding: ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(LoginActivity.EXTRA_USERNAME)
        val password = intent.getStringExtra(LoginActivity.EXTRA_PASSWORD)
        Toast.makeText(this, "user:$username pwd $password", Toast.LENGTH_SHORT).show()

        val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK){
                val intent = result.data
            }

            startRegistrationForResult.launch(registrationIntent)
        }

        binding.buttonRegisterConfirm.setOnClickListener{
            // TODO:verify that the information they entered is valiid
            var returnToLoginIntent = Intent().apply{
                putExtra(LoginActivity.EXTRA_USERNAME,
                    binding.editTextRegisterUsername.text.toString())
                putExtra(LoginActivity.EXTRA_PASSWORD,
                    binding.editTextRegisterPassword.text.toString())

            }
            setResult(Activity.RESULT_OK, returnToLoginIntent)
            finish()
        }
    }
}