package `Kotlin Standard Library`.HeapDataStructure.challenges

val integer = arrayOf(3, 10, 18, 5, 21, 100)

fun getNthSmallestElement(n:Element):Element?{

    when(!integer.isEmpty()){
        val element = remove()

        if(current ==n){
            return element
        }
            current += 1
    }
    return null
}
