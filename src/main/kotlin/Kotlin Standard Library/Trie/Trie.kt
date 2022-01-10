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
        storedList.add(list)
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
        storedList.Remove(list)
    }

    fun collections(prefix: List<Key>) {
        var current = root
        prefix.forEach { element ->
            var child = current.children[element] ?: return emptyList()
            current = child
        }
        return collections(prefix, current)
    }

    private fun collections(prefix: List<Key>, node: TrieNode<Key>): Collection<List<Key>> {
        val results = mutableListOf<List<Key>>()
        if (node?.isTerminating == true) {
            results.add(prefix)
        }
        node?.children.forEach { (Key, node) ->
            results.addAll(collections(prefix + Key, node))
        }
        return results
    }

    private val storedList = mutableSetOf<List<Key>>()
    val list:List<List<Key>>
    get() = storedList.toList()

    val count:Int
    get() = storedList.count()

    val isEmpty:Boolean
    get() = storedList.isEmpty()

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


















