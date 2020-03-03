package com.example.vaievolta

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class Outra : AppCompatActivity() {
    private lateinit var btOk: Button
    private lateinit var etMensagem: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outra)

        this.btOk = findViewById(R.id.btVolta)
        this.etMensagem = findViewById(R.id.etMensagemVolta)

        this.btOk.setOnClickListener(OnClickBotao())

        this.etMensagem.setText(intent.getStringExtra("MENSAGEM"))
    }

    inner class OnClickBotao: View.OnClickListener{
        override fun onClick(v: View?) {
            val it = Intent()
            val msg = this@Outra.etMensagem.text.toString()
            it.putExtra("MENSAGEM_VOLTA", msg)
            setResult(Activity.RESULT_OK, it)
            finish()
        }
    }
}
