package `Kotlin Standard Library`.AVLTrees

import `Kotlin Standard Library`.example
import kotlin.math.max

class AVLTree<T : Comparable<T>> {
    var root: AVLNode<T>? = null
    fun insert(value: T) {
        root = insert(root, value)
    }
    private fun insert(node: AVLNode<T>?, value: T): AVLNode<T> {
        node ?: return AVLNode(value)
        if (value <= node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }
        val balancedNode = balance(node)
        balancedNode.height = max(balancedNode?.leftHeight ?: 0, balancedNode?.rightHeight ?: 0) + 1
        return balancedNode
    }
    fun remove(value: T) {
        root = remove(root!!, value)
    }

    private fun remove(node: AVLNode<T>, value: T): AVLNode<T>? {
        node ?: return null
        when {
            value == node.value -> {

                if (node.leftChild == null && node.rightChild == null) {
                    return null
                }

                if (node.leftChild == null) {
                    return node.rightChild
                }
                if (node.rightChild == null) {
                    return node.leftChild
                }
                node.rightChild?.min?.value.let {
                    node.value = it!!
                }
                node.rightChild = remove(node.rightChild!!, node.value)
            }
            value < node.value -> node.leftChild = remove(node.leftChild!!, value)
            else -> node.rightChild = remove(node.rightChild!!, value)
        }
        val balancedNode = balance(node)
        balancedNode.height = max(balancedNode.rightHeight, balancedNode.leftHeight)+1
        return balancedNode
    }
    override fun toString() = root?.toString() ?: " empty tree"
    fun contains(value: T): Boolean {
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
    private fun leftRotate(node: AVLNode<T>): AVLNode<T> {
        val pivot = node.rightChild!!
        node.rightChild = pivot.leftChild
        pivot.leftChild = node
        node.height = max(node.rightHeight, node.leftHeight) + 1
        pivot.height = max(pivot.rightHeight, pivot.leftHeight) + 1
        return pivot
    }
    private fun rightRotate(node: AVLNode<T>): AVLNode<T> {
        val pivot = node.leftChild!!
        node.leftChild = pivot.rightChild
        pivot.rightChild = node
        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
        return node
    }
    private fun rightLeftRotate(node: AVLNode<T>): AVLNode<T> {
        val rightChild = node.rightChild ?: node
        node.rightChild = rightRotate(rightChild)
        return leftRotate(node)
    }

    private fun leftRightRotate(node: AVLNode<T>): AVLNode<T> {
        val leftChild = node.leftChild ?: node
        node.leftChild = rightRotate(leftChild)
        return rightRotate(node)
    }
    private fun balance(node: AVLNode<T>): AVLNode<T> {
        return when (node.balanceFactor) {
            2 -> {
                if (node.leftChild?.balanceFactor == -1) {
                    leftRightRotate(node)
                } else {
                    rightRotate(node)
                }
            }
            -2 -> {
                if (node.rightChild?.balanceFactor == 1) {
                    rightLeftRotate(node)
                } else {
                    leftRotate(node)
                }
            }
            else -> node
        }
    }
}
fun main() {
    "repeated insertions in sequence" example{
        val tree = AVLTree<Int>()

        tree.insert(15)
        tree.insert(10)
        tree.insert(16)
        tree.insert(18)
        println(tree)
        tree.remove(8)
        println(tree)
    }
}
