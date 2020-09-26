package com.example.minhascorespreferidas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class TelaCadastroDeCores : AppCompatActivity() {
    private lateinit var NomeCor : EditText
    private lateinit var HexadecimalCor : EditText
    private lateinit var SalvarCor : Button
    private lateinit var LLayout : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro_de_cores)

        this.NomeCor = findViewById(R.id.etNomeCor)
        this.HexadecimalCor = findViewById(R.id.etHexadecimalCor)
        this.SalvarCor = findViewById(R.id.btSalvarCor)
        this.LLayout = findViewById(R.id.ll)

        val tvNovo = TextView(this)
        tvNovo.text = this.HexadecimalCor.toString()
        tvNovo.setBackgroundColor(Color.parseColor(SalvarCor.toString()))

        LLayout.addView(tvNovo)

        this.SalvarCor.setOnClickListener{
            finish()
        }
    }
}