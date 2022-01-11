package `Kotlin Standard Library`.binarySearch


val array = arrayListOf(1, 2, 3, 3, 3, 4, 5, 5)
val indices = array.findIndices(3, 2..4)
fun <T : Comparable<T>> ArrayList<T>.findIndices(value: T, range: IntRange): IntRange? {

    val startIndex = indexOf(value)
    val endIndex = indexOf(value)

    if (startIndex == -1 || endIndex == -1) {
        return null
    }
    return startIndex..endIndex
}