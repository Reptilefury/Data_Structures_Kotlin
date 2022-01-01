package `Kotlin Standard Library`.BinaryTree

import max

typealias  Visitor<T> = (T) -> Unit

class BinaryNode<T>(val value: T) {

    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null


    override fun toString() = diagram(this)

    private fun diagram(
        node: BinaryNode<T>?,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                diagram(node.rightChild, "$top ", "$top┌──", "$top│ ") +
                        root + "${node.value}\n" + diagram(node.leftChild, "$bottom│ ", "$bottom└──", "$bottom ")
            }
        } ?: "${root}null\n"
    }

    //IN ORDER TRAVERSAL
    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    //PRE Order traversal
    fun preOrderTraversal(visit: Visitor<T>) {
        visit(value)
        leftChild?.preOrderTraversal(visit)
        rightChild?.preOrderTraversal(visit)
    }

    //Post order traversal We visit the children first and then we visit the Root node after the children have been visited first

    fun traversePostOrder(visit:Visitor<T>){
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }
    fun height(node: BinaryNode<T>? = this){
        return node.let {
    /*        if (node != null) {
            //    1 + max(height(node.leftChild),
                    height(node.rightChild)
                )
            } else -1*/
        }
    }
}

fun main() {

    val twentyOne = BinaryNode(21)
    val twentyTwo = BinaryNode(22)
    val twentyThree = BinaryNode(23)
    val twentyFour = BinaryNode(24)
    val twentyFive = BinaryNode(25)
    val twentySix = BinaryNode(26)
    val twentySeven = BinaryNode(27)
    val twentyEight = BinaryNode(28)

    twentyOne.leftChild = twentyTwo
    twentyTwo.leftChild = twentyThree
    twentyTwo.rightChild = twentyFour
    twentyOne.rightChild = twentyFive

    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8)
    val nine = BinaryNode(9)

    seven.leftChild = one
    one.leftChild = zero
    one.rightChild = five
    seven.rightChild = nine
    nine.leftChild = eight

    val tree = seven

    println(tree)

    val tree2 = twentyOne
    //  tree.traverseInOrder { println(it) }
    // tree.preOrderTraversal { println(it) }
    tree.traversePostOrder { println(it) }
    println(tree2)

}

