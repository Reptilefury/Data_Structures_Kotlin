package `Kotlin Standard Library`

import javax.swing.text.html.HTMLDocument

var size = 0
    private set

class LinkedList<T>:Iterable<T> {

    override fun iterator(): Iterator<T> {
        return  LinkedListIterator(this)

    }
    private var head: T? = null
    private var tail: T? = null
    private var size = 0

    fun isEmpty(): Boolean {
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

    fun NodeAt(index: Int): T? {
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




}
class  LinkedListIterator<T>:Iterator<T>{

    override fun next(): T {
        TODO("Not yet implemented")
    }

    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }


}