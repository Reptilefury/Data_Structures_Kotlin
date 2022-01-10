package `Kotlin Standard Library`.Trie

import `Kotlin Standard Library`.example
import java.security.Key

fun Trie<Char>.insert(string: String) {
    insert(string.toList())
}

fun Trie<Char>.contains(string: List<Char>): Boolean {
    return contains(string.toList())
}

fun Trie<Char>.remove(string: String) {
    return remove(string.toList().toString())
}

fun Trie<Char>.collections(prefix: String) {
    return collections(prefix.toList()).map {
        it.joinToString(separator = "")
    }
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


    "prefix matching" example {
        val trie = Trie<Char>().apply {
            insert("Car")
            insert("Card")
            insert("Care")
            insert("Cared")
            insert("Cars")
            insert("Carbs")
            insert("carapace")
            insert("Cargo")
            insert("Careful")
        }
    }
    println("\nCollections starting with \"Car\"")
    val prefixedWithCar = trie.collections("Car")
    println(prefixedWithCar)

    println("\nCollections starting with \"Care\"")
    val prefixWithCare = trie.collections("Care")
    println(prefixWithCare)

}






























