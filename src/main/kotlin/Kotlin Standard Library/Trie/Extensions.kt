package `Kotlin Standard Library`.Trie

import `Kotlin Standard Library`.example

fun Trie<Char>.insert(string: String) {
    insert(string.toList())
}

fun Trie<Char>.contains(string: List<Char>): Boolean {
    return contains(string.toList())
}

fun Trie<Char>.remove(string: String) {
    return remove(string.toList().toString())
}

fun main() {
    "Remove" example {
        val trie = Trie<Char>()
        trie.insert("Cut")
        trie.insert("Cute")

        println("\n***Before Removing")
        assert(trie.Contains("Cut".toList()))
        println("\"cut\" is in the trie")
        assert(trie.contains("Cute".toList()))
        println("\"Cute\" is in the trie")


        println("\n***After removing cut")
        trie.remove("Cut")
        assert(!trie.contains("Cut".toList()))
        assert(trie.contains("Cute".toList()))
        println("\nCute\" is still in the trie")



    }
}



















