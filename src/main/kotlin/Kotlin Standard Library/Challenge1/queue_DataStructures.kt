package `Kotlin Standard Library`.Challenge1

import java.util.*

fun <T: Any> Queue<T>.nextPlayer():T?{
    val person = this.dequeue() ?: return null
    this.enqueue(person)
    return person
}