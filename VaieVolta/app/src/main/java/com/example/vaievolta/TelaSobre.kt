package com.example.vaievolta

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class TelaSobre : AppCompatActivity() {
    private lateinit var imagem: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_sobre)

        this.imagem = findViewById(R.id.iMe)

        this.imagem.setOnClickListener {
            val intent = Intent(this, Interesting::class.java)
            startActivity(intent)
        }
    }
}
