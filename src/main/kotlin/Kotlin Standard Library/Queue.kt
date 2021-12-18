package `Kotlin Standard Library`
/*
interface Queue<T>{
    fun enqueue(element:T):Boolean
    fun dequeue():T
    val count:Int
    get
    val isEmpty:Boolean
    get()= count == 0
    fun peek():T?


}*/
interface  Queue<T>{
    fun enqueue(element:T):Boolean
    fun dequeue():T?
    val count:Int
    get
    val isEmpty:Boolean
    get()= count == 0
    fun  peek():T?
}
fun main(){
    "Queue with ArrayList" example{
      val queue = ArrayListQueue<String>().apply {
          enqueue("David Degea")
          enqueue("Eric Baily")
          enqueue("Luke Shaw")
          enqueue("Harry Maguire")
          enqueue("Aaron Wan B")
          enqueue("McFred")
          enqueue("Bruno")
          enqueue("Jadon Sancho")
          enqueue("Cristiano Ronaldo")
          enqueue("Give it give it to Edi Cavani!!")
      }
        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up: ${queue.peek()}")
    }
}