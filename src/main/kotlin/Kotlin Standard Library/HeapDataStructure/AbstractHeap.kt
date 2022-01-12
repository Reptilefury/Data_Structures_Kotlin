package `Kotlin Standard Library`.HeapDataStructure

abstract class AbstractHeap<Element> : Heap<Element> {
    abstract fun compare(a: Element, b: Element): Boolean
    var elements: ArrayList<Element> = ArrayList<Element>()

    override val count: Int
        get() = elements.size

    override fun peek(): Element? = elements.first()
    private fun leftChildIndex(index: Int) = (2 * index) + 1
    private fun rightChildIndex(index: Int) = (2 * index) + 2

    private fun parentIndex(index: Int) = (index - 1)


    override fun insert(element: Element) {
        elements.add(element)
        siftUp(count - 1)
    }

    private fun siftUp(index: Int) {
        var child = index
        var parent = parentIndex(child)

        while(child > 0 &&  compare(elements[child], elements[parent]>0)){
            child = parent
           parent = parentIndex(child)
        }
    }
}





















