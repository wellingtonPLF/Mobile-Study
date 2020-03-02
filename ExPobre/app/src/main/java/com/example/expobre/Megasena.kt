package com.example.expobre

import java.util.*

object Megasena {

    fun getInstance():List<Int>{
        val random = Random()
        var number = mutableSetOf<Int>()

        while(number.size < 6){
            number.add(random.nextInt(60)+1)
        }

        return number.toList().sorted()
    }
}