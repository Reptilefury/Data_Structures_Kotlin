package `Kotlin Standard Library`

import javax.swing.text.html.HTMLDocument

var size = 0
    private set

class LinkedList<T>:Iterable<T>, Collection<T>,MutableIterator<T>, MutableCollection<T>{


    override fun iterator(): MutableIterator<T> {
        return  LinkedListIterator(this)

    }
    private var head: T? = null
    private var tail: T? = null
  override  var size = 0

   override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        if (isEmpty()) {
            return "Empty List"
        } else {
            return head.toString()
        }
    }

    fun push(value: T): LinkedList<T> {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        }
        tail?.next = Node(value = value)
        tail = tail?.next
        size++
    }

    fun NodeAt(index: Int): Node<T> {
        var currentNode = head
        var currentIndex = index

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T> {

        if (tail == afterNode) {
            append(value)
            return tail!!
        }
        val newNode = Node(value = value, next = afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }
    /*  fun pop():T?{
          if(isEmpty()) size--
              val result = head?.value
              head = head?.next
          if(isEmpty()){
              tail = null
          }
          return  result
      }*/

       fun pop():T?{
           if(isEmpty())--size
           val result = head?.value
           head = head?.next
           if(isEmpty()){
               tail = null
           }
           return result
       }

     /*  fun removeLast():T?{
           val head = head? : return null
           if(head.next == null ) retun pop()
           size--

           var prev = head
           var current = head
           var next = current.next
           while (next != null){

               prev = current
               current = next
               next = current.next
           }
           prev.next = null
           tail  = prev
           return  current.value
       }*/

    fun removeLast():T?{
        val head = head?: return null
        if(head.next  == null) return pop()
        size--
        var prev = head
        var current = head
        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }
        prev.next = null
        tail = prev
        return current.value
    }
    /*  fun removeAfter(node:Node<T>):T?{
           val result = node.next?.value
          if(node == tail){
              tail = node
          }
           if(node.next != null){
               size--
           }
       node.next = node.next?.next
      return  result
      }
  */
    fun removeAfter(node:Node<T>):T?{
        val result = node.next?.value
        if(node.next == tail){
            tail = node
        }
        if(node.next != null){
            size--
        }
        node.next = node.next?.next
        return  result


    }

    override fun contains(element: T): Boolean {
        for(item  in  this){
            if(item == element) return  true
        }
        return  false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
      for (searched in elements){
          if (!contains(searched))return  false
      }
        return  true
    }

    override fun add(element: T): Boolean {
        append(element)
        return true
    }

    override fun addAll(elements: Collection<T>): Boolean {
        for(element in elements){
                append(element)
            }
        return true
    }


    override fun clear() {

         head = null
         tail = null
         size = 0
    }

    override fun remove(element: T): Boolean {

    val iterator = iterator()
        while(iterator.hasNext()){
            val item = iterator.next()
            if(item == element){
                iterator.remove()
                return  true
            }
        }
        return false
    }

    override fun removeAll(elements: Collection<T>): Boolean {
     var result = false
        for (item in elements){
            result = remove(item)|| result
        }
        return result
    }
    override fun retainAll(elements: Collection<T>): Boolean {
    var result = false
       val iterator = this.iterator()
        while (iterator.hasNext()){
            val iterator = iterator.next()
            if(!elements.contains(item)){
                iterator.remove()
                result = true
            }
        }
        return  result
    }


}
class  LinkedListIterator<T>(private val list:LinkedList<T>):Iterator<T>,MutableIterator<T>{
private var lastNode:Node<T>?=null
     private var index = 0
    override fun next(): T {
        if (index >= list.size) throw IndexOutOfBoundsException()
        lastNode = if (index == 0){
            list.NodeAt(0)
        } else{
            lastNode?.next
        }
       index++

        return  lastNode!!.value

    }

    override fun hasNext(): Boolean {
        return index< list.size

    }

    override fun remove() {
        if(index == 1){
            list.pop()
        } else{
            val prevNode = list.NodeAt(index -2)?: return
            list.removeAfter(prevNode)
        }
        index--
    }
}