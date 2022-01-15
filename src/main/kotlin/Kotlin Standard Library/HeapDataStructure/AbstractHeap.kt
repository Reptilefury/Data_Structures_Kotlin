package `Kotlin Standard Library`.HeapDataStructure

import java.util.*
import kotlin.collections.ArrayList

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

    override fun remove(index: Int): Element? {
        if(index>= count)  return  null
        return if(index == count - 1){
            elements.removeAt(count - 1)
        } else {
            Collections.swap(elements, index, count - 1)
            val item = elements.removeAt(count - 1)
            siftDown(index)
            siftUp(index)
            item
        }

    }



   /* override fun remove(): Element?{
        if(isEmpty) return null

        Collections.swap(elements, 0 , count - 1)
        val  item = elements.removeAt(count - 1)

        siftDown(0)
        return item
    }*/

    private fun siftDown(index: Int){
        var parent = index
        while (true){
            val left = leftChildIndex(parent)
            val  right = rightChildIndex(parent)
            var candidate = parent
            if(left < count && compare(elements[left] , elements[candidate] > 0)){
                candidate = left
            }
            if(right < count && compare(elements[right], elements[candidate])){
                candidate = right
            }
            if(candidate == parent){
                return
            }
            Collections.swap(elements,parent, candidate)

            parent = candidate
        }
    }

    private fun siftUp(index: Int) {
        var child = index
        var parent = parentIndex(child)

        while(child > 0 &&  compare(elements[child], elements[parent]>0)){
            child = parent
           parent = parentIndex(child)
        }
    }
    private fun Index(element: Element,i: Int): Int? {
        if(i >= count){
            return null
        }
        if(sort(element, elements[i])){
            return null
        }
        if(element == elements[i]){
            return  i
        }
        val leftChildIndex = Index(element, leftChildIndex(i))
        if(leftChildIndex != null ) return leftChildIndex


        val rightChildIndex = Index(element, rightChildIndex(i))
        if(rightChildIndex != null) return  rightChildIndex

        return null
    }

    protected fun heapify(values:ArrayList<Element>){
        elements = values
        if(!elements.isEmpty()){

            (count /2 downTo 0).forEach {
                siftDown(it)
            }
        }
    }
}




























