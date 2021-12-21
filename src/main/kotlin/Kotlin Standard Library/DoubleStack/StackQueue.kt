package `Kotlin Standard Library`.DoubleStack

import `Kotlin Standard Library`.StackImpl
import `Kotlin Standard Library`.example
import java.util.*

class StackQueue<T:Any>: Queue<T> {

    private val leftStack= StackImpl<T>()
    private val rightStack = StackImpl<T>()

    override val isEmpty:Boolean
    get() = leftStack.isEmpty && rightStack.isEmpty

    private fun transferElements(){
        var nextElement = rightStack.pop()
        while (nextElement!= null){
            leftStack.push(nextElement)
            nextElement = rightStack.pop()

        }
    }

    override fun peek(): T? {
        if (leftStack.isEmpty){
            transferElements()
        }
        return leftStack.peek()
    }
    override  fun enqueue(element:T):Boolean{
        rightStack.push(element)
        return true
    }

    fun dequeue(): T? {
        if(leftStack.isEmpty){
            transferElements()
        }
        return leftStack.pop()
    }

    override fun toString(): String {
        return "LeftStack: \n$leftStack \nRight Stack: \n$rightStack"
    }

}
fun main(){
    "Queue with double stack" example{
        val queue = StackQueue<String>().apply {
            enqueue("Lena")
            enqueue("Anna")
            enqueue("Jenna")
            enqueue("Isla")
            enqueue("Zany")
            enqueue("Emily")
        }
        println(queue)
        queue.dequeue()
        println(queue)
        println("Next Up: ${queue.peek()}")

    }
}
