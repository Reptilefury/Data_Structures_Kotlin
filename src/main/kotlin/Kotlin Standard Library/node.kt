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
data class Node<T>(var value: T, var next: Node<T>? = null){
    override fun toString():String{
        return if(next != null){
            "$value -> ${value.toString()}"
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
        var middleNode = list.NodeAt(1)!!
        for(i  in 1..3){
            middleNode = list.insert(-1 * i , middleNode)

        }
        println("After inserting: $list")

    }
}
private infix fun Any.example(function: () -> Unit) {
 return function()
}

