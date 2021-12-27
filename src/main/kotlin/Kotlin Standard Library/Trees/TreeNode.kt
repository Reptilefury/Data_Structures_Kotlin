package `Kotlin Standard Library`.Trees

import `Kotlin Standard Library`.ArrayListQueue

class TreeNode<T>(val value: T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()
    fun add(child: TreeNode<T>) = children.add(child)
    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }

    fun forEachlevelOrder(visit: Visitor<T>) {
        visit(this)
        val queue = ArrayListQueue<TreeNode<T>>()
        children.forEach { queue.enqueue(it) }
        var node = queue.dequeue()
        while (node != null) {
            visit(node)
            node.children.forEach{queue.enqueue(it)}
            node = queue.dequeue()
        }
    }
    fun printEachLevel(){
        val queue = ArrayListQueue<TreeNode<T>>()
        var nodesLeftInCurrentLevel = 0

        queue.enqueue(this)
        while (queue.isEmpty.not()){
            nodesLeftInCurrentLevel = queue.count
            while (nodesLeftInCurrentLevel > 0){
                val node = queue.dequeue()
                node?.let {
                    print("${node.value}")
                    node.children.forEach{
                        queue.enqueue(it)
                    }
                    nodesLeftInCurrentLevel--
                }?:break
            }
            println()
        }
    }

    fun search(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null
        forEachlevelOrder {
            if (it.value == value) {
                result = it
            }
        }
        return result
    }

}


typealias Visitor<T> = (TreeNode<T>) -> Unit

fun main(){

    fun makeBeverage():TreeNode<String>{
        val tree = TreeNode("Beverages")

        val hot = TreeNode("Hot")
        val cold = TreeNode("Cold")

        val tea  = TreeNode("Tea")
        val coffee = TreeNode("Coffee")
        val chocolate = TreeNode("Chocolate")

        val blackTea = TreeNode("BlackTea")
        val greenTea = TreeNode("Green Tea")
        val  chaiTea = TreeNode("Chai Tea")

        val soda = TreeNode("Soda")
        val milk = TreeNode("Milk")

        val bitterLemon = TreeNode("BitterLemon")
        val gingerAle = TreeNode("GingerAle")

        tree.add(hot)
        tree.add(cold)

        hot.add(tea)
        hot.add(coffee)
        hot.add(chocolate)
        hot.add(milk)

        cold.add(soda)


        tea.add(blackTea)
        tea.add(greenTea)
        tea.add(chaiTea)

        soda.add(bitterLemon)
        soda.add(gingerAle)

        return  tree

    }



    val Hot = TreeNode("Hot")
    val Cold = TreeNode("Cold")
    val alcohol = TreeNode("Vodka")
    val brandy  = TreeNode("Brandy")
    val whisky = TreeNode("Whisky")
    val softDrinks = TreeNode("CocaCola")
    val beverages = TreeNode("Beverages").run {
        Cold.add(Cold)
        Hot.add(Hot)

    }


    val Drinks = TreeNode("BestServedCold").run {
        alcohol.add(alcohol)
        brandy.add(brandy)
        whisky.add(whisky)
        softDrinks.add(softDrinks)
    }
    val tree = makeBeverage()
    tree.forEachDepthFirst { println(it.value) }
    tree.forEachlevelOrder { println(it.value) }
    tree.search("ginger ale")?.let {
        println("Found Node: ${it.value}")
    }
    tree.search("WKD Blue")?.let {
        println(it.value)
    }?: println("WKD blue")
}