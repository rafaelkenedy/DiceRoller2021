package com.example.diceroller2021

class Dice(private val sides: Int) {

    fun roll():Int {
        return (1..sides).random()
    }
}