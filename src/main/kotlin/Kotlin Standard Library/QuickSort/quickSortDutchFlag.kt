package `Kotlin Standard Library`.QuickSort

import `Kotlin Standard Library`.example
import `Kotlin Standard Library`.swapAt


fun <T : Comparable<T>> MutableList<T>.partitionDutchFlag(low: Int, high: Int, pivotIndex: Int): Pair<Int, Int> {
    val pivot = this[pivotIndex]
    var smaller = low
    var equal = low
    var larger = high

    while (equal <= larger) {
        if (this[equal] < pivot) {
            this.swapAt(smaller, equal)
            smaller += 1
            equal += 1
        } else if (this[equal] == pivot) {
            equal += 1
        } else {
            this.swapAt(equal, larger)
            larger -= 1
        }
    }
    return Pair(smaller, larger)
}

fun <T : Comparable<T>> MutableList<T>.quickSortDutchFlag(low: Int, high: Int) {
    if (low < high) {
        val middle = partitionDutchFlag(low, high, high)
        this.quickSortDutchFlag(low, middle.first - 1)
        this.quickSortDutchFlag(middle.second + 1, high)

    }
}


fun main() {

    "Quick sort Dutch Flag" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original:$list")
        list.quickSortDutchFlag(0, list.size - 1)
        println("Sorted:$list")
    }
}













