package `Kotlin Standard Library`.QuickSort

import `Kotlin Standard Library`.example
import `Kotlin Standard Library`.swapAt


fun <T:Comparable<T>> MutableList<T>.partitionHoare(low:Int, high:Int):Int{
    val pivot = this[low]
    var i = low - 1
    var j = high + 1
    while (true){
        do {
            j += 1
        } while (this[j]>pivot)
        do {
            i += 1
        } while (this[i] < pivot)
        if (i < j){
            this.swapAt(i,j)
        } else {
            return j
        }
    }
}
fun<T:Comparable<T>> MutableList<T>.quickSortHoare(low:Int, high: Int){
    if (low<high){
        val p = this.partitionHoare(low, high)
        this.quickSortHoare(low, p)
        this.quickSortHoare(p + 1 , high)
    }
}

fun main(){
    "Quick sort Hoare" example{
        val  list = arrayListOf(12, 0, 3, 9, 2, 21, 18, 27, 1, 5, 8, -1, 8)
        println("Original:$list")
        list.quickSortHoare(0, list.size -1)
        println("Sorted:$list")
    }
}







