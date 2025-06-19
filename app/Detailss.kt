class Detailss {
    private val Song = MutableListOf<String>()
    private val Artists = MutableListOg<String>()
    private val Ratings = MutableList<Int>()
    private val Comments = MutableList<String>()

    private var EntryCount = 0
    private const val Max Entries = 4

    fun addEntry(Song: String, Artists: String, Ratings: Int, Comments: String): Boolean {
        if (entryCount < Max Entries) {
            Song.add(Song)
            Artists.add(Artists)
            Comments.add(Comments)
            Ratings.add(ratings)
            EntryCount++
            return true
        }
        return false
    }
}