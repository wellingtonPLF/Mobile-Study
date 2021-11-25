package com.example.minhascorespreferidas

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.lang.Exception

class Base_Adapter(private var context: Context, private var cadastroCores : ArrayList<CadastroCores>) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val name = this.cadastroCores.get(position).getNome()
        val hexa = this.cadastroCores.get(position).getHexadecimal()
        val view_ : View

        if (convertView == null){
            view_ = LayoutInflater.from(context).inflate(R.layout.colors_data, null)
        }
        else{
            view_ = convertView
        }

        val tv = view_.findViewById<TextView>(R.id.tv)

        try {
            tv.text = name
            tv.setBackgroundColor(Color.parseColor(hexa))
        }
        catch (e: Exception){
            Log.i("APP_ERROR", " Name: "+name+"| Hexa: "+hexa)
        }
        return view_
    }

    override fun getItem(position: Int): Any {
        return this.cadastroCores.get(position)
    }

    override fun getItemId(position: Int): Long {
        return -1
    }

    override fun getCount(): Int {
        return this.cadastroCores.count()
    }
}