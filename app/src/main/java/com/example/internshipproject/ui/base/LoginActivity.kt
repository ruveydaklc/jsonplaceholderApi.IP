package com.example.internshipproject.ui.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.example.internshipproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val sampUserName:String = "user"
        val sampPassword:String= "1111"

        binding.btnLogIn.setOnClickListener{
            if (binding.etUserName.text.toString() == sampUserName && binding.etPassword.text.toString() == sampPassword){
                Toast.makeText(this,"Login successful.", Toast.LENGTH_SHORT).show()
                var intent= Intent(this,MainActivity::class.java)
                resultLauncher.launch(intent)
            }
            else{
                AlertWarning()
            }
        }

    }

    fun AlertWarning(){
        val adb: AlertDialog.Builder= AlertDialog.Builder(this)
        adb.setTitle("Login Error!")
        adb.setMessage("Your username and password do not match. Try again.")
        adb.setPositiveButton("Ok",null)
        adb.show()
    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    { result ->
        if (result.resultCode== RESULT_CANCELED)
        {
            Toast.makeText(this, "Please login again.", Toast.LENGTH_SHORT).show()
        }

    }
}