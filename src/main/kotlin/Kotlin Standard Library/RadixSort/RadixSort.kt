package `Kotlin Standard Library`.RadixSort

import `Kotlin Standard Library`.example
import `Kotlin Standard Library`.numbers

val list = arrayListOf(88, 410, 1772, 20)
fun MutableList<Int>.radixSort() {
    val base = 10
    var done = false
    var digits = 1
    while (!done) {
        done = true
        val buckets = ArrayList<MutableList<Int>>().apply {
            for (i in 0..9) {
                this.add(arrayListOf())
            }
        }
        this.forEach { number ->
            val remainingPart = number / digits
            val digit = remainingPart % base
            buckets[digit].add(number)
            if (base > 0) {
                done = false
            }
        }
        digits *= base
        this.clear()
        this.addAll(buckets.flatten())
    }
}

fun main() {
    "Radix sorted" example {
        val list = arrayListOf(88, 20, 1772, 410)
        println("Original List: $list")
        list.radixSort()
        println("Radix Sorted:$list")
    }
}









