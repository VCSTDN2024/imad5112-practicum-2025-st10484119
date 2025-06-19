package com.example.playlistmanager


import android.content.Context
import android.widget.Toast

object Detail {
    private val Song = MutableListOf<String>()
    private val Artists = MutableListOf<String>()
    private val Ratings = MutableList<Int>()
    private val Comments = MutableList<String>()

    private var EntryCount = 0
    private const val MaxEntries = 4

    fun addEntry(Song: String, Artists: String, Ratings: Int, Comments: String): Boolean {
        if (EntryCount < MaxEntries) {
            Song.add(Song)
            Artists.add(Artists)
            Comments.add(Comments)
            Ratings.add(Ratings)
            EntryCount++
            return true
        }
        return false
    }

}

