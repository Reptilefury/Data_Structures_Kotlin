package `Kotlin Standard Library`.BinaryTree
import `Kotlin Standard Library`.Trees.TreeNode
import `Kotlin Standard Library`.ArrayListQueue

typealias  Visitor<T> = (T) -> Unit
class BinaryNode<T>(val value:T){

    var leftChild:BinaryNode<T>?=null
    var rightChild:BinaryNode<T>?=null


   override fun toString() = diagram(this)

    private fun diagram(node:BinaryNode<T>?,
        Top:String,
        Bottom:String,
        Root:String):String {
        if (node != null) {
            return node.let {
                if (node?.leftChild == null && node?.rightChild == null) {
                    "$Root${node.value}\n"
                } else {
                    diagram(node.rightChild, "$Top ", "$Top┌──", "$Top│ ") +
                            Root + "${node.value}\n" + diagram(node.leftChild, "$Bottom│ ", "$Bottom└──", "$Bottom ")
                }
            } ?: "${Root}null \n"
        }
    }
}
        fun main(){
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

            val  tree = seven

            println(tree)

        }

