package `Kotlin Standard Library`.AVLTrees.Challenges

import `Kotlin Standard Library`.AVLTrees.AVLTree
import `Kotlin Standard Library`.AVLTrees.Visitor
import `Kotlin Standard Library`.example
import kotlin.math.pow

fun leafNodes(height: Int): Int {
    return 2.0.pow(height).toInt()
}

abstract class TraverseBinaryNode<Self : TraverseBinaryNode<Self, T>, T>(var value: T) {
    var leftChild: Self? = null
    var rightChild: Self? = null


    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    fun traversePreOrder(visit: Visitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    fun traversePostOrder(visit: Visitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }
}

fun numberOfNodesInTree(currentHeight: Int): Int {
    var totalNodes = 0
    (0..currentHeight).forEach {
        totalNodes += 2.0.pow(currentHeight).toInt()
    }
    return totalNodes
}

fun nodes(height: Int): Int {
    return 2.0.pow(height + 1).toInt() - 1
}

fun main() {
   /* val NumbeOfNodes = leafNodes(3)
    println(NumbeOfNodes)
    val nodesInTree = numberOfNodesInTree(2)
    println(nodesInTree)
    val numberOfNodesBigO = nodes(2)
    println(numberOfNodesBigO)*/
    "Using traversableBinaryNode" example {
        val tree = AVLTree<Int>()
        (0..14).forEach {
            tree.insert(it)
        }
        println(tree)
        tree.root?.traverseInOrder { println(it) }
    }
}

