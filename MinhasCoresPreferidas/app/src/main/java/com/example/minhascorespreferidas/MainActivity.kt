package com.example.minhascorespreferidas

import android.app.Activity
import android.content.Intent
import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    private lateinit var lvCores : ListView
    private lateinit var btTelaCadastro: Button
    private lateinit var lista : ArrayList<CadastroCores>
    val token = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lvCores = findViewById(R.id.lvCores)
        this.btTelaCadastro = findViewById(R.id.btTelaCadastro)
        this.lista = ArrayList()

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

        this.lista.add(CadastroCores("Roxo","#483D8B"))
        this.lista.add(CadastroCores("Azul","#00BFFF"))
        this.lista.add(CadastroCores("Marrom","#B8860B"))
        this.lista.add(CadastroCores("Roza","#9400D3"))
        this.lista.add(CadastroCores("Caucazian","#FFB6C1"))

        this.lvCores.adapter = Base_Adapter(this, this.lista)
        this.lvCores.setOnItemLongClickListener(clickLongo())

        this.btTelaCadastro.setOnClickListener{
            val intent = Intent(this, TelaCadastroDeCores::class.java)
            startActivityForResult(intent, token)
        }
    }

    private fun atualiza(){
        (this.lvCores.adapter as BaseAdapter).notifyDataSetChanged()
    }

    /*private fun convert(cor : Int){
        this.lista.add(CadastroCores("","#" + Integer.toHexString(cor).substring(2)))
    }*/

    inner class clickLongo : AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) : Boolean{
            this@MainActivity.lista.removeAt(position)
            atualiza()
            return true
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == token) {
                val cor = data?.getSerializableExtra("NewColor") as CadastroCores
                this.lista.add(cor)
                atualiza()
            }
        }else{
            Toast.makeText(this, "Voltou pelo Dispositivo", Toast.LENGTH_SHORT).show()
        }
    }
}
