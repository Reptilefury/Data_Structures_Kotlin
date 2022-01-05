package `Kotlin Standard Library`.AVLTrees

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
        return node
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
        return node
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
}