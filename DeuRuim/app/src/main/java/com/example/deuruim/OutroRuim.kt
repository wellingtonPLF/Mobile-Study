package com.example.deuruim

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.SeekBar
import androidx.core.view.drawToBitmap

class OutroRuim : AppCompatActivity() {

    private lateinit var etDescricao: EditText
    private lateinit var sbNota: SeekBar
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button
    private lateinit var btFoto: Button
    private lateinit var imgvFoto: ImageView

    val PICTURE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outro_ruim)

        this.etDescricao = findViewById(R.id.etFormDescricao)
        this.sbNota = findViewById(R.id.sbFormNota)

        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btCancelar = findViewById(R.id.btFormCancelar)
        this.btFoto = findViewById(R.id.btFoto)
        this.imgvFoto = findViewById(R.id.imgvFoto)

        this.btSalvar.setOnClickListener({ salvar() })
        this.btFoto.setOnClickListener({ foto() })
        this.btCancelar.setOnClickListener({
            finish()
        })
    }

    fun salvar(){
        val descricao = this.etDescricao.text.toString()
        val nota = this.sbNota.progress
        val foto = this.imgvFoto.drawToBitmap()

        val evento = Evento(descricao, nota, foto)

        val intent = Intent()
        intent.putExtra("EVENTO", evento)

        setResult(Activity.RESULT_OK, intent)

        finish()
    }

    fun foto() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, PICTURE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == PICTURE) {
            val imagem = data?.extras?.get("data") as Bitmap
            this.imgvFoto.setImageBitmap(imagem)
        }
    }
}
