package com.example.dpi

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Camera
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.net.URL
import android.widget.RadioButton
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

//Alt+Enter (LAMP GOD)

class MainActivity : AppCompatActivity() {
    private lateinit var btCamera: Button
    private lateinit var btFoto: Button
    private lateinit var btDownload: Button
    private lateinit var imageV: ImageView
    val cameraID = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btCamera = findViewById(R.id.btCamera)
        this.btFoto = findViewById(R.id.btFoto)
        this.btDownload = findViewById(R.id.btDownload)
        this.imageV = findViewById(R.id.imgV)

        this.btCamera.setOnClickListener { camera() }
        this.btFoto.setOnClickListener { foto() }
        this.btDownload.setOnClickListener { download() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == cameraID){
                val imagem = data?.extras?.get("data") as Bitmap
                this.imageV.setImageBitmap(imagem)
            }
        }
    }

    fun camera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, cameraID)
    }

    fun foto(){
        this.imageV.setImageResource(R.drawable.super_mario)
    }

    @SuppressLint("ResourceType")
    fun download(){

        val janela = AlertDialog.Builder(this)
        janela.setTitle("Escolha uma resolução.")
        janela.setIcon(R.mipmap.ic_launcher)

        val radiobt1 = RadioButton(this)
        radiobt1.setText("ldpi")
        radiobt1.isChecked = true
        radiobt1.id = 0

        val radiobt2 = RadioButton(this)
        radiobt2.setText("mdpi")
        radiobt2.id = 1

        val radiobt3 = RadioButton(this)
        radiobt3.setText("hdpi")
        radiobt3.id = 2

        val radiobt4 = RadioButton(this)
        radiobt4.setText("xhdpi")
        radiobt4.id = 3

        val radiobt5 = RadioButton(this)
        radiobt5.setText("xxhdpi")
        radiobt5.id = 4

        val radiobt6 = RadioButton(this)
        radiobt6.setText("xxxhdpi")
        radiobt6.id = 5

        val radio = RadioGroup(this)
        radio.addView(radiobt1)
        radio.addView(radiobt2)
        radio.addView(radiobt3)
        radio.addView(radiobt4)
        radio.addView(radiobt5)
        radio.addView(radiobt6)

        janela.setPositiveButton("OK"){dialog, which ->  ok(radio)}
        janela.setView(radio)
        janela.create().show()
    }

    fun ok(r: RadioGroup){
        //var url : String
        var url = "http://www.valeria.eti.br/sm/sm_ldpi.png"
        for(x in 0..5){
            val rs = r.getChildAt(x) as RadioButton
            if(rs.isChecked() == true){
                url = "http://www.valeria.eti.br/sm/sm_"+rs.getText().toString()+".png"
            }
        }

        val handler = Handler()
        Thread{
            val imagem = this.downloadDaImagem(url)

            handler.post{
                this.imageV.setImageBitmap(imagem)
            }
        }.start()
    }

    fun downloadDaImagem(url: String) : Bitmap{
        URL(url).openStream().use {
            val imagem = BitmapFactory.decodeStream(it)
            return imagem
        }
    }
}
