package `Kotlin Standard Library`.Trie

import `Kotlin Standard Library`.example

class Trie<Key> {
    private val root = TrieNode<Key>(null, null)
    fun insert(list: List<Key>) {
        var current = root
        list.forEach { element ->
            if (current.children[element] == null) {
                current.children[element] = TrieNode(element, current)
            }
            current = current.children[element]!!
        }
        current.isTerminating = true
    }

    fun Contains(list: List<Key>): Boolean {
        var current = root
        list.forEach { element ->
            var child = current.children[element] ?: return false
            current = child
        }
        return current.isTerminating
    }

    fun Remove(collection: Collection<>) {
        var current = root
        collection.forEach {
            var child = current.children[it] ?: return
            current = child
        }
        if (!current.isTerminating) return
        current.isTerminating = false

        var parent = current.parent
        while (current.children.isEmpty() && !current.isTerminating) {
            parent?.let {
                it.children[current.key] = null
                current = it
            }
        }
    }
}

fun main() {
    "Insert and contains" example {
        val trie = Trie<Char>()
        trie.insert("CUTE".toList())
        if (trie.Contains("CUTE".toList())) {
            println("CUTE is in the trie")
        }
    }
}


















