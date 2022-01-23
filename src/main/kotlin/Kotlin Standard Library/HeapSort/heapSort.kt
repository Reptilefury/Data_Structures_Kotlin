package `Kotlin Standard Library`.HeapSort

import `Kotlin Standard Library`.example

private fun leftChildIndex(index: Int) = (2 * index) + 1
private fun rightChildIndex(index: Int) = (2 * index) + 2
fun <T> Array<T>.siftDown(
    index: Int,
    upTo: Int,
    comparator: Comparator<T>
) {
    var parent = index
    while (true) {
        val left = leftChildIndex(parent)
        val right = rightChildIndex(parent)
        var candidate  = parent

        if(left< upTo &&
                comparator.compare(this[left], this[candidate]) > 0
                ) {
            candidate = right
        }
        if (candidate == parent){
            return
        }
     this.swapAt(parent, candidate)
        parent = candidate
    }
}
fun <T> Array<T>.heapify(comparator: Comparator<T>){
        if(this.isNotEmpty()){
            (this.size / 2 downTo 0).forEach{
                this.siftDown(it, this.size, comparator)
            }
     }
}
fun <T> Array<T>.heapSort(comparator: Comparator<T>){
    this.heapify(comparator)
    for(index in this.indices.reversed()){
        this.swapAt(0, index)
        siftDown(index, 0, comparator)
    }
}

fun main(){
    "Heap Sort" example{
        val array = arrayOf(6, 12, 2, 26, 8, 18, 21, 9, 5)
        array.heapSort(ascending)
        println(array.joinToString())
    }
}













