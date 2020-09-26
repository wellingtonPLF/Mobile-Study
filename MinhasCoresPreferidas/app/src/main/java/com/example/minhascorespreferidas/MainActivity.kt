package com.example.minhascorespreferidas

import android.content.Intent
import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    private lateinit var lvCores : ListView
    private lateinit var btTelaCadastro: Button
    private lateinit var lista : CadastroCores

    val TOTEN = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lvCores = findViewById(R.id.lvCores)
        this.btTelaCadastro = findViewById(R.id.btTelaCadastro)
        this.lista = CadastroCores()

        /*
        var cor1 : Int = ContextCompat.getColor(this, R.color.colorAccent)
        var cor2 : Int = ContextCompat.getColor(this, R.color.colorGreenBlue)
        var cor3 : Int = ContextCompat.getColor(this, R.color.colorGreenBlue)
        var cor4 : Int = ContextCompat.getColor(this, R.color.colorGreenBlue)
        var cor5 : Int = ContextCompat.getColor(this, R.color.colorGreenBlue)
        convert(cor1)
        convert(cor2)
        convert(cor3)
        convert(cor4)
        convert(cor5)
        */

        this.lista.add("#483D8B")
        this.lista.add("#00BFFF")
        this.lista.add("#B8860B")
        this.lista.add("#9400D3")
        this.lista.add("#FFB6C1")

        this.lvCores.adapter = Base_Adapter(this, lista)
        this.lvCores.setOnItemLongClickListener(clickLongo())

        this.btTelaCadastro.setOnClickListener{
            val intent = Intent(this, TelaCadastroDeCores::class.java)
            startActivityForResult(intent, TOTEN)
        }
    }

    fun convert(cor : Int){
        this.lista.add("#" + Integer.toHexString(cor).substring(2))
    }

    inner class clickLongo : AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) : Boolean{
            this@MainActivity.lista.remove(position)
            return true
        }
    }
}