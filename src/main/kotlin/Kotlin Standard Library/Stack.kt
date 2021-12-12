package `Kotlin Standard Library`

import javax.lang.model.element.Element

/*interface Stack<Element>{
    fun push(element: Element)
    fun  pop():Element?
}*/
class  Stack<T:Any>(){
private val storage = arrayListOf<T>()
    override fun toString() = buildString {
        appendln("-----top------")
        storage.asReversed().forEach {
            appendln("$it")
        }
        appendln("-------")
    }

override fun push(element: Element){
    storage.add(element)
}
    override fun  pop():Element{
        if (storage.size == 0){
            return null
        }
        return storage.removeAt(storage.size - 1)
    }

}