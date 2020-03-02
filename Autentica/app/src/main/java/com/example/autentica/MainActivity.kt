package com.example.autentica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var edSenha: EditText
    private lateinit var edUsuario: EditText
    private lateinit var bt1Cancel: Button
    private lateinit var bt2Ok: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.edSenha = findViewById(R.id.edSenha)
        this.edUsuario = findViewById(R.id.edUsuario)
        this.bt1Cancel = findViewById(R.id.bt1Cancel)
        this.bt2Ok = findViewById(R.id.bt2Ok)

        this.bt2Ok.setOnClickListener(onClickBt())
        this.bt1Cancel.setOnClickListener({
            this.edSenha.text.clear()
            this.edUsuario.text.clear()})
    }

    inner class onClickBt: View.OnClickListener{
        override fun onClick(v: View?) {
            if(edSenha.text.toString() == "1234" && edUsuario.text.toString() == "admin"){
                val intent = Intent(this@MainActivity , SecondOne::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this@MainActivity, "Incorrect! Try again.", Toast.LENGTH_SHORT).show()
                edSenha.text.clear()
                edUsuario.text.clear()
            }
        }
    }
}

