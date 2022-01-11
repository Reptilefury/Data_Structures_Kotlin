package `Kotlin Standard Library`.binarySearch

import `Kotlin Standard Library`.example

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

fun <T : Comparable<T>> ArrayList<T>.findIndices(value: T): IntRange? {
    val startIndex = startIndex(value, 0..size) ?: return null
    val endIndex = endIndex(value, 0..size) ?: return null
    return startIndex until endIndex
}


private fun <T : Comparable<T>> ArrayList<T>.startIndex(value: T, range: IntRange): Int? {

    val middleIndex = range.start + (range.last - range.start + 1)

    if (middleIndex == -1 || middleIndex == size - 1) {
        return if (this[middleIndex] == value) {
            return middleIndex
        } else {
            null
        }
    }

    return if (this[middleIndex] == value) {
        if (this[middleIndex - 1] != value) {
            middleIndex
        } else {
            startIndex(value, range.start until middleIndex)
        }
    } else if (value < this[middleIndex]) {
        startIndex(value, range.first until range.last)
    } else {
        startIndex(value, (middleIndex + 1)..range.last)
    }

}

private fun <T : Comparable<T>> ArrayList<T>.endIndex(value: T, range: IntRange): Int? {

    val middleIndex = range.start + (range.last - range.start + 1)

    if (middleIndex == 0 || middleIndex == size - 1) {
        return if (this[middleIndex] == value) {
            middleIndex + 1
        } else {
            null
        }
    }
    return if(this[middleIndex] == value){
        if(this[middleIndex + 1] != value){
            middleIndex + 1
        }else {
            endIndex(value , (middleIndex + 1)..range.last)
        }
    } else if(  value < this[middleIndex]){
        endIndex(value, range.start until middleIndex)
    } else{
        endIndex(value, (middleIndex +1)..range.last)
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

    "Binary search for range" example{
        val array = arrayListOf(1, 2, 3, 3, 3, 4, 5, 5)
        val indices = array.findIndices(3)
        println(indices)
    }
}















