package com.example.minhascorespreferidas

class CadastroCores {

    private lateinit var lista : ArrayList<String>

    init {
        this.lista = ArrayList()
    }

    fun add(cor : String){
        this.lista.add(cor)
    }

    fun get(index : Int) : String{
        return this.lista.get(index)
    }

    fun get() : ArrayList<String>{
        return this.lista
    }

    fun count() : Int{
        return this.lista.count()
    }

    fun remove(index : Int){
        lista.removeAt(index)
    }
}