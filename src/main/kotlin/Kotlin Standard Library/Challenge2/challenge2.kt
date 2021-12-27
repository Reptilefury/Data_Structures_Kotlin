package `Kotlin Standard Library`.Challenge2

import `Kotlin Standard Library`.Trees.TreeNode
import `Kotlin Standard Library`.ArrayListQueue

fun main() {
    val tree = makeTree()
    tree.printEachLevel()
}

fun makeTree(): TreeNode<Int> {
    val tree = TreeNode(15)
    val one = TreeNode(1)
    tree.add(one)
    val seventeen = TreeNode(17)
    tree.add(seventeen)


    val twenty = TreeNode(20)
    tree.add(twenty)

    val one2 = TreeNode(1)
    val five = TreeNode(5)
    val zero = TreeNode(0)
    one.add(one2)
    one.add(five)
    one.add(zero)

    val two = TreeNode(2)
    seventeen.add(two)
    val five2 = TreeNode(5)
    val seven = TreeNode(7)
    twenty.add(five2)
    twenty.add(seven)
    return tree

}
