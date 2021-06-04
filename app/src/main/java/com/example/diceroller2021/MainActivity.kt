package com.example.diceroller2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val rollButton: Button = findViewById(R.id.btn_roll)

        //Do a dice roll when the app starts
        rollDice()

        rollButton.setOnClickListener{ rollDice() }

    }

    /**
     * Roll the dice and udpate the creen with results.
     */

    private fun rollDice(){
        //Create a new Dice object with 6 dies and roll the dice
        val firstDice = Dice(6)
        val secondDice = Dice(6)
        val diceRoll = firstDice.roll()
        val secondDiceRoll = secondDice.roll()

        //Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.iv_dice)
        val secondDiceImage: ImageView = findViewById(R.id.iv_second_dice)

        val rolls = arrayOf(diceRoll, secondDiceRoll)
        val drawablesResources = arrayOf(diceImage, secondDiceImage)

        for(roll in rolls){

        //Determine wich drawable resource ID to use based on the dice roll
            val drawableResource = when(roll){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            //Update the ImageView with the correct drawable resource ID
            drawablesResources[rolls.indexOf(roll)].setImageResource(drawableResource)
        }

        //Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}