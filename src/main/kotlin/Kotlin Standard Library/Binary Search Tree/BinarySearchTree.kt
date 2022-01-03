package `Kotlin Standard Library`.`Binary Search Tree`

import `Kotlin Standard Library`.BinaryTree.BinaryNode
import `Kotlin Standard Library`.example

class BinarySearchTree<T:Comparable<T>>(){
    var root:BinaryNode<T>? = null
    override fun toString() = root?.toString() ?: "Empty Tree"

    fun insert(value:T){
        root = insert(root, value)
    }

    private fun insert(node: BinaryNode<T>?, value: T): BinaryNode<T> {
        node ?: return BinaryNode(value)
        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }
        return node
    }

    fun contains(value: T): Boolean {
        /*   root?: return false
           var found = false
           root?.traverseInOrder {
               if(value == it){
                   found = true
               }
           }
           return  found*/
        var current = root
        while (current != null) {

            if (current.value == value) {
                return true
            }
            current = if (value < current.value) {
                current.leftChild
            } else {
                current.rightChild
            }
        }
        return false
    }

    fun remove(value: T) {
        root = remove(root, value)
    }
    private fun remove(
        node: BinaryNode<T>?,
        value: T
    ):BinaryNode<T>?{

        if (node?.leftChild== null && node?.rightChild == null){
            return  null
        }
        if(node?.leftChild == null) {
            return  node.rightChild
        }
        if(node?.rightChild == null){
            return node.leftChild
        }
        node?.rightChild?.min?.value.let {
            if (it != null) {
                node?.value = it
            }
            node.rightChild = remove(node.rightChild, node.value)
        }


        node?:return null
        when {
            value == node.value -> {
            }
            value < node.value -> node.leftChild = remove(node.leftChild, value)
            else -> node.rightChild = remove(node.rightChild, value)
        }
        return node
    }
    fun contains(subTree: BinarySearchTree<T>): Boolean {
        val set = mutableSetOf<T>()
        root?.traverseInOrder{
            set.add(it)
        }

        var isEquals = true
        subTree?.root?.traverseInOrder {
            isEquals = isEquals && set.contains(it)
        }

        return isEquals
    }


}
fun main(){


    val exampleTree = BinarySearchTree<Int>().apply {
        insert(3)
        insert(1)
        insert(4)
        insert(0)
        insert(2)
        insert(5)

    }
    "Building a BST" example {
        /*      val bst = BinarySearchTree<Int>()
              (0..4).forEach {

                  bst.insert(it)

              }*/
        println(exampleTree)
    }
    "finding a node" example {
        if (exampleTree.contains(5)) {
            println("Found 5!")
        } else {
            println("Couldn't find 5")
        }
    }
    "Removing a node" example {
         println("Tree before removal: ")
         println(exampleTree)
        exampleTree.remove(3)
        println("Tree after removing Root:")
        println(exampleTree)
    }


}