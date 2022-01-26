package `Kotlin Standard Library`.QuickSort

import `Kotlin Standard Library`.example
import `Kotlin Standard Library`.swapAt

fun <T : Comparable<T>> MutableList<T>.medianOfThree(low: Int, high: Int): Int {
    val centre = (low + high) / 2
    if (this[low] > this[centre]) {
        this.swapAt(low, high)
    }
    if (this[centre] > this[high]) {
        this.swapAt(centre, high)
    }
    return centre
}
fun <T : Comparable<T>> MutableList<T>.quickSortMedian(low: Int, high: Int){
    if(low<high){
        val pivotIndex = medianOfThree(low, high)
        this.swapAt(pivotIndex, high)
        val pivot = partitionLomuto(low,high)
        this.quickSortLomuto(low,pivot -1)
        this.quickSortLomuto(pivot +1 , high)
   }
}
fun main(){
    "Quick sort median" example {
        val list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original:$list")
        list.quickSortMedian(0,list.size-1)
        println("Sorted:$list")
    }
}



















