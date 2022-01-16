package `Kotlin Standard Library`.HeapDataStructure

class ComparatorHeapImpl<Element>(
    private val comparator: Comparator<Element>
) : AbstractHeap<Element>() {
    override fun compare(a: Element, b: Element): Int = comparator.compare(a, b)

    override val count: Int
        get() = TODO("Not yet implemented")

    override fun insert(element: Element) {
        TODO("Not yet implemented")
    }

    override fun remove(): Element? {
        TODO("Not yet implemented")
    }

    override fun remove(index: Int): Element? {
        TODO("Not yet implemented")
    }

    override fun peek(): Element? {
        TODO("Not yet implemented")
    }
    companion object {
        fun <Element> create(
            elements: ArrayList<Element>,
            comparator: Comparator<Element>
        ): Heap<Element> {
            val heap = ComparatorHeapImpl(comparator)
            heap.heapify(elements)
            return heap
        }
    }
}

fun main() {
    val array = arrayListOf(1, 12, 3, 4, 1, 6, 8, 7)
    val priorityQueue = ComparableHeapImpl.Create(array)

    while (!priorityQueue.isEmpty) {
        println(priorityQueue.remove())
    }
    val array2 = arrayListOf(1,12,3,4,1,6,8,7)

    val inverseComparator = object : Comparator<Int> { // 2
        override fun compare(o1: Int, o2: Int): Int = o2.compareTo(o1)
    }
    val minHeap = ComparatorHeapImpl.create(array, inverseComparator) // 3
    while (!minHeap.isEmpty) { // 4
        println(minHeap.remove())
    }
}

}














