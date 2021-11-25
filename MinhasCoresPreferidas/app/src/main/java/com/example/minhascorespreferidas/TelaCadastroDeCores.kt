package com.example.minhascorespreferidas

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TelaCadastroDeCores : AppCompatActivity() {
    private lateinit var NomeCor : EditText
    private lateinit var HexadecimalCor : EditText
    private lateinit var SalvarCor : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro_de_cores)

        this.NomeCor = findViewById(R.id.etNomeCor)
        this.HexadecimalCor = findViewById(R.id.etHexadecimalCor)
        this.SalvarCor = findViewById(R.id.btSalvarCor)

        this.SalvarCor.setOnClickListener{
            val cor = CadastroCores(this.NomeCor.text.toString(), this.HexadecimalCor.text.toString())
            val itent = Intent()
            itent.putExtra("NewColor", cor)
            setResult(Activity.RESULT_OK, itent)
            finish()
        }
    }
}