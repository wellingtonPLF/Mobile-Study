package com.example.expobre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var tvN: TextView
    private lateinit var botao: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.botao = findViewById(R.id.button)
        this.tvN = findViewById(R.id.tvNumber)

        //this.gerarNovoJogo(null)     //Add onclick no xml e chamar essa função
        botao.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        this.tvN.text = Megasena.getInstance().joinToString(" ")
    }
    
    //fun gerarNovoJogo(view: View?){
    //    this.tvN.text = Megasena.getInstance().joinToString(" ")
    //}
}
