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

        botao.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        this.tvN.text = Megasena.getInstance().joinToString(" ")
    }
}
/*
package com.example.expobre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){. //.View.OnClickListener [Forma 3]
    private lateinit var tvN: TextView
    private lateinit var botao: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.botao = findViewById(R.id.button)
        this.tvN = findViewById(R.id.tvNumber)

        //this.gerarNovoJogo(null)     //Add onclick no xml e chamar essa função [Forma1]
        //this.botao.setOnClickListener({gerarNovoJogo(it)}) //Sem a add do onclick no xml [Forma2]
        //this.botao.setOnClickListener(this) //[Forma 3]
        
        this.botao.setOnClickListener(OnClickBotao()) //Forma 4
    }

    //override fun onClick(v: View?) {                                  //Forma 3
    //    this.tvN.text = Megasena.getInstance().joinToString(" ")
    //}
    
    //fun gerarNovoJogo(view: View?){                                   //Forma 1 e 2
    //    this.tvN.text = Megasena.getInstance().joinToString(" ")
    //}
    
    /* Forma 4 */
    
    inner class OnClickBotao : View.OnClickListener{
        override fun onClick(v: View?) {                                 
            this@MainActivity.tvN.text = Megasena.getInstance().joinToString(" ")
            
        }
    }
}
*/