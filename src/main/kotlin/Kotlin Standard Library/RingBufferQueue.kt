package `Kotlin Standard Library`
class  RingBufferQueue<T : Any>(size:Int):Queue<T>{
    private  val ringBuffer:RingBuffer<T> = RingBuffer(size)
    override val count:Int
     get() = ringBuffer.count

    override fun peek(): T? = ringBuffer.first
   override fun enqueue(element:T):Boolean =
        ringBuffer.write(element)

    override fun dequeue():T? =
        if(isEmpty) null else ringBuffer.read()

    override fun toString(): String = ringBuffer.toString()

}
fun main(){
    "Queue with ring buffer" example{
        val queue =RingBufferQueue<String>(10).apply {
            enqueue("Jenna")
            enqueue("Lena")
            enqueue("Anna")
            enqueue("Isla")
            enqueue("Emily")
            enqueue("Zany")
        }
        println(queue)
        queue.dequeue()
        println(queue)
        println("Next up:${queue.peek()}")


    }
}