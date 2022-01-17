package `Kotlin Standard Library`.`Priority Queues`

import `Kotlin Standard Library`.HeapDataStructure.Heap
import `Kotlin Standard Library`.Queue

abstract class AbstractPriorityQueue<T>:Queue<T> {
    abstract val heap:Heap<T>
    get

    override fun enqueue(element: T): Boolean {
        heap.insert(element)
        return true
    }
    override fun dequeue(): T? = heap.remove()
    override val count: Int
        get() = heap.count

    override fun peek(): T? = heap.peek()


}