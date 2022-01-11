package `Kotlin Standard Library`

fun <T : Comparable<T>> ArrayList<T>.binarySearch(value: T, range: IntRange): Int? {
    if (range.first > range.last) {
        return null
    }
    val size = range.last - range.first + 1
    val middle = range.first + size
    return when {
        this[middle] == value -> middle
        this[middle] > value -> binarySearch(value, range.first until middle)

        else -> binarySearch(value, (middle + 1)..range.last)
    }
}

fun main() {
    "Binary search" example {
        val array = arrayListOf(1, 5, 15, 17, 19, 22, 24, 31, 105, 150)
        val search31 = array.indexOf(31)
        val binarySearch31 = array.binarySearch(31)

        println("IndexOf31: $search31")
        println("binarySearch31: $binarySearch31")
    }
}















