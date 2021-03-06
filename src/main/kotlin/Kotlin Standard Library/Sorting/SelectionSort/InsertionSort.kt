package `Kotlin Standard Library`.Sorting.SelectionSort

import `Kotlin Standard Library`.example
import `Kotlin Standard Library`.swapAt


fun <T:Comparable<T>> MutableList<T>.insertionSort(showPasses:Boolean = false)  {

    if (this.size < 2) return

    for (current in 1 until this.size ){

        for (shifting in (1..current).reversed()){

            if(this[shifting] < this[shifting - 1]){
                this.swapAt(shifting , shifting - 1)
            } else {
                break
            }
        }
        if(showPasses) println(this)
    }
}
fun main(){
    "Insertion sort" example{
        val list = arrayListOf(9,4,10,3)
        println("Original:$list")
        list.insertionSort(true)
        println("Sorted: $list")
    }
}















