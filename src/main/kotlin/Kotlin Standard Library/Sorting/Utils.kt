package `Kotlin Standard Library`

fun <T> MutableList<T>.swapAt(first: Int, second: Int) {
    val aux = this[first]
    this[first] = this[second]
    this[second] = aux
}

fun <T : Comparable<T>> MutableList<T>.bubbleSort(showPasses: Boolean = false) {
    if (this.size < 2)
        return
    for (end in (1 until this.size).reversed()) {
        var swapped = false
        for (current in 0 until end) {
            if (this[current] > this[current + 1]) {
                this.swapAt(current, current + 1)
                swapped = true
            }
        }
        if (showPasses) println(this)
        if (!swapped) return
    }
}

fun main() {
    "Bubble sort" example {
        val list = arrayListOf(9, 4, 10, 3)
        println("Original:$list")
        list.bubbleSort(true)
        println("Bubble sorted: $list")


    }
}




















