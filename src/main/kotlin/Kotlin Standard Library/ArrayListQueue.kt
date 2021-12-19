package `Kotlin Standard Library`

class ArrayListQueue<T>:Queue<T>{
    private  val list = arrayListOf<T>()
    override val count: Int
        get() = list.size

    override fun peek(): T? = list.getOrNull(0)
    override fun enqueue(element: T): Boolean {
        list.add(element)
        return true
    }

    override fun dequeue(): T? =
        if(isEmpty) null else list.removeAt(0)

    override fun toString(): String  = list.toString()

}

class LinkedListQueue<T : Any>:Queue<T>{
    private val list = DoublyLinkedList<T>()
    private var  size = 0

    override val count:Int
    get () =
        size

    override fun enqueue(element: T): Boolean {
        list.append(element)
        size ++
        return  true
    }

    override fun dequeue(): T? {
        val firstNode = list.first ?:  return  null
        size --

        return list.remove(firstNode)

    }
    override fun peek(): T? = list.first?.value
    override fun toString(): String = list.toString()
}

fun main(){
   "Queue with doubly linked list" example {
       val  queue = LinkedListQueue<String>().apply {
           enqueue("David")
           enqueue("Eric")
           enqueue("Degea")
           enqueue("Luke Shaw")
           enqueue("McFred")
           enqueue("Bruno")
           enqueue("Give it give it to Edi Cavani!!")
       }
       println(queue)
       queue.dequeue()
       println(queue)
       println("Next up:${queue.peek()}")
   }

}