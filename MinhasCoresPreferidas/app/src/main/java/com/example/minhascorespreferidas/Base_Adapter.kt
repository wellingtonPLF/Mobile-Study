package com.example.minhascorespreferidas

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Base_Adapter(private var context: Context, private var cadastroCores : CadastroCores) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val cor = this.cadastroCores.get(position)
        val view_ : View

        if (convertView == null){
            view_ = LayoutInflater.from(context).inflate(R.layout.colors_data, null)
        }
        else{
            view_ = convertView
        }

        val tv = view_.findViewById<TextView>(R.id.tv)
        tv.text = cor
        tv.setBackgroundColor(Color.parseColor(cor))
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