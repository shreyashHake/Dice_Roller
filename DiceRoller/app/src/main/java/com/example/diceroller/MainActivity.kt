package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //This line invokes when button is clicked
        val rollDice: Button = findViewById(R.id.button)
        //This will indicate what to do when user clicks button {This is the lambada function}
        rollDice()
        rollDice.setOnClickListener {
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
            rollDice()
        }
    }

    //This will command the code to roll the dice
    private fun rollDice() {
        //Here we are creating the object of Dice() class
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()

        // The variable describes the image on the screen
        val diceImage: ImageView = findViewById(R.id.imageView)

        //The when condition decides the drawable resource i.e. choose which image to assign
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Showing which image to display
        diceImage.setImageResource(drawableResource)

        //Setting the contentDescription so than screen readers can read what output is obtained
        diceImage.contentDescription = diceRoll.toString()

        val diceImage2: ImageView = findViewById(R.id.imageView3)

        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage2.setImageResource(drawableResource2)
        diceImage2.contentDescription = diceRoll2.toString()
    }
}

//Create the Dice() class to create a user defined dice
class Dice(private val numOfSides: Int) {
    //This function returns the random number
    fun roll(): Int {
        return (1..numOfSides).random()
    }
}