package com.example.minhascorespreferidas

import java.io.Serializable

class CadastroCores(nome: String, hexadecimal: String) : Serializable{

    private lateinit var nome :String
    private lateinit var hexadecimal: String

    init {
        this.nome = nome
        this.hexadecimal = hexadecimal
    }

    fun getNome() : String{
        return this.nome
    }

    fun getHexadecimal() : String{
        return this.hexadecimal
    }

    fun setNome(nome: String){
        this.nome = nome
    }

    fun setHexadecimal(hexadecimal: String){
        this.hexadecimal = hexadecimal
    }
}