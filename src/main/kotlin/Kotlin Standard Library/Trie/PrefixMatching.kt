package `Kotlin Standard Library`.Trie

class EnglishDictionary {
    private val words: ArrayList<String> = arrayListOf()

    fun words(prefix: String) = words.filter { it.startsWith(prefix) }

}