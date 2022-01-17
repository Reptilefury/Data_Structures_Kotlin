package `Kotlin Standard Library`.`Priority Queues`

import `Kotlin Standard Library`.HeapDataStructure.ComparableHeapImpl
import `Kotlin Standard Library`.HeapDataStructure.ComparatorHeapImpl
import `Kotlin Standard Library`.HeapDataStructure.Heap
import `Kotlin Standard Library`.example

class ComparablePriorityQueueImpl<T : Comparable<T>> :
    AbstractPriorityQueue<T>() {
    override val heap = ComparableHeapImpl<T>()
}


class ComparatorPriorityQueueImpl<T>(
    private val comparator: Comparator<T>
) : AbstractPriorityQueue<T>() {
    override val heap: Heap<T> = ComparatorHeapImpl(comparator)

}

fun main() {
    "max priority queue" example {
        val priorityQueue = ComparablePriorityQueueImpl<Int>()

        arrayListOf(1, 12, 3, 4, 1, 6, 8, 7).forEach {
            priorityQueue.enqueue(it)
        }
        while (!priorityQueue.isEmpty)
            println(priorityQueue.dequeue())
    }
    "Min priority Queue" example {
        val stringLengthComparator = object : Comparator<String> {
            override fun compare(o1: String?, o2: String?): Int {
                val length1 = o1?.length ?: -1
                val length2 = o2?.length ?: -1
                return length1 - length2


            }
        }
        val priorityQueue = ComparatorPriorityQueueImpl(stringLengthComparator)

        arrayListOf("one", "two", "three", "forty", "five", "six", "seven", "eight", "nine").forEach {
            priorityQueue.enqueue(it)
        }
        while(!priorityQueue.isEmpty){
            println(priorityQueue.dequeue())
        }
    }
}



















