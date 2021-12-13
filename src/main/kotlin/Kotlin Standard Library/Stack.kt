package `Kotlin Standard Library`

import javax.lang.model.element.Element

interface Stack<Element>{
    fun push(element: Element)
    fun  pop():Element?
 fun peek():Element?
 val count:Int
 get
 val isEmpty:Boolean
 get()= count == 0


}
class  StackImpl<T:Any>:Stack<T>{
private val storage = arrayListOf<T>()
    override fun toString() = buildString {
        appendln("-----top------")
        storage.asReversed().forEach {
            appendln("$it")
        }
        appendln("-------")
    }
    override fun push(element:T){
        storage.add(element)
    }
    override fun pop(): T? {
        if (isEmpty){
            return null
        }
        return storage.removeAt(count -1)
    }
/*    override fun  pop():T?{
        if (storage.size == 0){
            return null
        }
        return storage.removeAt(storage.size - 1)
    }*/

    override fun peek(): T? {
        return  storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size


}