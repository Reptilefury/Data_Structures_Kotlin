package `Kotlin Standard Library`.`Binary Search Tree`

import `Kotlin Standard Library`.BinaryTree.BinaryNode
import `Kotlin Standard Library`.example

class BinarySearchTree<T:Comparable<T>>(){
    var root:BinaryNode<T>? = null
    override fun toString() = root?.toString() ?: "Empty Tree"

    fun insert(value:T){
        root = insert(root, value)
    }
    private fun insert(node: BinaryNode<T>?, value: T,):BinaryNode<T>{
        node?: return  BinaryNode(value)
        if(value < node.value){
            node.leftChild = insert(node.leftChild, value)
        } else{
            node.rightChild = insert(node.rightChild, value)
        }

         return  node
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
    "Building a BST" example{
  /*      val bst = BinarySearchTree<Int>()
        (0..4).forEach {

            bst.insert(it)

        }*/
        println(exampleTree)
    }

}