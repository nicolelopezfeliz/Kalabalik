package com.example.kalabalik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var playerAmount: EditText
    lateinit var buttonNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playerAmount = findViewById(R.id.amountOfPlayers)
        buttonNext = findViewById(R.id.buttonNext)

        buttonNext.setOnClickListener{
            buttonNextPage()
            buttonNext.visibility = View.INVISIBLE
        }
    }

    fun buttonNextPage(){
        GameSettings.playerCount = playerAmount.text.toString().toInt()

        val playerFragment = PlayerFragment()
        val transaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.playerFragmentContainer, playerFragment, "playerFragment")
        transaction.commit()

    }
}