package `Kotlin Standard Library`

/*
data class Node<T>(var value: T, var next: Node<T>?=null){
    override fun toString():String {
        return if(next != null ){
            "$value -> ${value.toString()}"
        } else{
            return "$value"
        }
    }
}*/
data class Node<T : Any>(var value: T, var next: Node<T>? = null, var previous:Node<T>?=null) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}
fun main(){


    "creating and linking nodes" example{

        val node1 = Node(2 )
        val node2 = Node(3)
        val node3 = Node(4)
        val node4 = Node(5)

        node1.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = null

        println(node3)

    }
    "push" example {
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)

        println(list)
    }
    "fluent interface" example {
        val list = LinkedList<Int>()
        list.push(3).push(2).push(1)
        println(list)
    }

    "append" example {
        val list = LinkedList<Int>()
        list.append(3)
        list.append(2)
        list.append(1)
        println(list)
    }
    "Inserting at a particular index" example{
        val list = LinkedList<Int>()
        list.append(3)
        list.append(2)
        list.append(1)
        print("Before inserting: $list")
        var middleNode = list.nodeAt(1)!!
        for(i  in 1..3){
            middleNode = list.insert(-1 * i , middleNode)

        }
        println("After inserting: $list")

    }

    "pop" example{
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)
        println("Before popping list: $list")
        val poppedvalue = list.pop()
        println("After popping list: $list")
        println("Popped value: $poppedvalue")
    }
    "remove last node" example{
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)
        println("Before removing last node: $list")
        val removedValue = list.removeLast()
        println("After removing last node:$list")
        println("Removed value: $removedValue")

    }
    "Removing a node at a particular node" example{
        val list = LinkedList<Int>()
        list.push(3)
        list.push(2)
        list.push(1)
        println("Before removing at a particular index: $list")
        val index = 1
        val node = list.nodeAt(index - 1)!!
        val removedValue = list.removeAfter(node)
        println("After removing at index $index: $list")
        println("Removed value: $removedValue")

    }
    "Printing Doubles" example {
        val list = LinkedList<Int>()
        list.push(3).push(2).push(1)
        println(list)

        for (EveryItem in list) {
            println("Double: ${EveryItem * 2}")
        }
    }
    "Removing elements" example {
        val list: MutableCollection<Int> = LinkedList()
        list.add(3)
        list.add(2)
        list.add(1)
        println(list)
        list.remove(1)
        println(list)
    }
    "Retaining elements" example {
        val list: MutableCollection<Int> = LinkedList()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)
        println(list)
        list.retainAll(listOf(3, 4, 5))
        println(list)
    }
    "remove all elements" example {
        val list: MutableCollection<Int> = LinkedList()
        list.add(3)
        list.add(2)
        list.add(1)
        list.add(4)
        list.add(5)
        println(list)
        list.removeAll(listOf(3, 4, 5))
        println(list)
    }

    "Using a stack" example{
        val stack = StackImpl<Int>().apply{
            push(1)
            push(2)
            push(3)
            push(4)
        }
        print(stack)
        val poppedElement = stack.pop()
        if (poppedElement != null) {
            println("popped:$poppedElement")
        }
        print(stack)
    }
    "initializing a stack from a list" example {
        val list = listOf("A", "B", "C", "D")
        val stack = StackImpl.create(list)
        print(stack)
        println("Popped: ${stack.pop()}")
    }
    "initializing a stack from any array literal" example {
        val stack = stackOf(1.0, 2.0, 3.0, 4.0)
        print(stack)
        println("Popped:${stack.pop()}")

    }


}
infix fun Any.example(function: () -> Unit) {
 return function()
}

