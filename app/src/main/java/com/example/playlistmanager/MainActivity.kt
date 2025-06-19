package com.example.playlistmanager
// St10484119 Divesh Moodley

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore.Audio.Artists
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.mutableIntListOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess
                                        // all arrays
val songTitles = ArrayList<String>()
 val artistNames = ArrayList<String>()
 val ratings = ArrayList<String>()
 val comments = ArrayList<String>()
private var ratingTTL : Int = 0

var EntryCount = 0
var MaxEntries = 4







class MainActivity : AppCompatActivity() {
                                                    // all varaibles that will be called on this page
    private lateinit var ETSongTitle: EditText
    private lateinit var ETArtist: EditText
    private lateinit var ETRating: EditText
    private lateinit var ETComment: EditText
    private lateinit var DetailBtn: Button
    private lateinit var ExitBtn: Button
    private lateinit var AddBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
                                                        // finding all variables by IDs
        ETSongTitle = findViewById(R.id.ETSongTitle)
        ETComment = findViewById(R.id.ETComment)
        ETArtist = findViewById(R.id.ETArtist)
        ETRating = findViewById(R.id.ETRating)
        DetailBtn = findViewById(R.id.DetailBtn)
        ExitBtn = findViewById(R.id.ExtBtn)
        AddBtn = findViewById(R.id.AddBtn)



        ExitBtn.setOnClickListener() {              // exit button function
            finishAffinity()
            exitProcess(0)
        }


        DetailBtn.setOnClickListener() {                                    // Function for the Next screen Button
            val Intent = Intent(this, Details::class.java)
            intent.putExtra("Song Name", songTitles)
            intent.putExtra("Artist Name", artistNames)
            intent.putExtra("Rating", ratings)
            intent.putExtra("Comments", comments)
            startActivity(Intent)
        }




        fun addSong(title: String, artist: String, rating: String, comment: String) {                      // function which allows the add button to work
            if (title.isEmpty() || artist.isEmpty() || comment.isEmpty()) {                                 // error handleing with empty inputs
                Toast.makeText(this, "Invalid Information", Toast.LENGTH_SHORT).show()
                return
            } else {


                songTitles.add(title)
                artistNames.add(artist)
                ratings.add(rating)
                comments.add(comment)

                Toast.makeText(this, "Song added!", Toast.LENGTH_SHORT).show()

            }
        }




        AddBtn.setOnClickListener {                                                                           // Add Button which populates the arrays
            if (EntryCount < MaxEntries) {
                addSong(
                    ETSongTitle.text.toString(),
                    ETArtist.text.toString(),
                    ETRating.text.toString(),
                    ETComment.text.toString()
                )
                EntryCount++




            } else {                                                                                        // error handleing to allow only 4 entries max
                Toast.makeText(this, "Max Entries Reached ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}