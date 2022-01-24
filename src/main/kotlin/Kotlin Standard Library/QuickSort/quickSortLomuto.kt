package `Kotlin Standard Library`.QuickSort

import `Kotlin Standard Library`.example
import `Kotlin Standard Library`.swapAt


fun <T : Comparable<T>> MutableList<T>.partitionLomuto(low: Int, high: Int): Int {
    val pivot = this[high]
    var i = low
    for (j in low until high) {
        if (this[j] <= pivot) {
            this.swapAt(i, j)
            i += 1
        }
    }
    this.swapAt(i, high)
    return i
}

fun <T : Comparable<T>> MutableList<T>.quickSortLomuto(low: Int, high: Int) {
    if (low < high) {
        val pivot = this.partitionLomuto(low, high)
        this.quickSortLomuto(low, pivot - 1)
        this.quickSortLomuto(pivot + 1, high)
    }
}

fun main() {
    "Lomuto quick sort" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original:$list")
        list.quickSortLomuto(0, list.size - 1)
        println("Sorted:$list")
    }
}
























