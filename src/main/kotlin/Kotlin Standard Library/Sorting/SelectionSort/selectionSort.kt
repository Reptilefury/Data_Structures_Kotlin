package `Kotlin Standard Library`.Sorting.SelectionSort

import `Kotlin Standard Library`.example
import `Kotlin Standard Library`.swapAt

fun <T : Comparable<T>> ArrayList<T>.selectionSort(showPasses: Boolean = false) {
    if (this.size < 2) return
    for (current in 0 until (this.size - 1)) {
        var lowest = current
        for (other in (current + 1) until this.size) {
            if (this[lowest] > this[other]) {
                lowest = other
            }
        }
        if (lowest != current) {
            this.swapAt(lowest, current)
        }
        if (showPasses) println(this)
    }
}

fun main() {
    "Selection sort" example {
        val list = arrayListOf(9, 4, 10, 3)
        println("Original:$list")
        list.selectionSort()
        println("Bubble sorted:$list")
    }
}










