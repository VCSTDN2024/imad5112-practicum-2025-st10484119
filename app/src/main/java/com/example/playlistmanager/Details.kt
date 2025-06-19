package com.example.playlistmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Details : AppCompatActivity() {

    private lateinit var DisplayBtn: Button                 //all varibales that will be used are called
    private lateinit var AvgBtn: Button
    private lateinit var BackButton: Button
    private lateinit var tvDetails: TextView
    private lateinit var tvAvg: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)

        DisplayBtn = findViewById(R.id.DisplayBtn)                  // finding all variables by Ids
        AvgBtn = findViewById(R.id.AvgBtn)
        BackButton = findViewById(R.id.BackBtn)
        tvDetails = findViewById(R.id.tvDetails)
        tvAvg = findViewById(R.id.tvAvg)



        BackButton.setOnClickListener() {                                       // Button to return to the main screen
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }

        DisplayBtn.setOnClickListener() {                                       // Display Button and code which shows the details of information in the arrays
            val builder = StringBuilder()
            for (i in songTitles.indices) {
                builder.append("${i + 1}, ${songTitles[1]}" + "${i + 1}, ${artistNames[1]}" + ", ${ratings[1]}" + ", ${comments[1]}")
                builder.append("\n---------------------------\n")

            }
            tvDetails.text = builder.toString()
        }

         fun CalcAvg() : Int {                                      //function to calculate the average rating
             var sum = 0
             for (i in ratings.indices){
                 sum = sum + ratings[i].toString().toInt()
             }
             return sum / 4
         }

        AvgBtn.setOnClickListener(){                                //button to display the average rating
            tvAvg.text = "The average is : " + CalcAvg()
        }
    }
}




