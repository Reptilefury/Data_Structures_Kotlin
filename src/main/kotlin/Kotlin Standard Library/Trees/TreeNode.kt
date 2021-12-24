package `Kotlin Standard Library`.Trees

class TreeNode<T>(val value: T){
    private val children:MutableList<TreeNode<T>> = mutableListOf()
    fun add(child:TreeNode<T>) = children.add(child)
    fun forEachDepthFirst(visit:Visitor<T>){
      visit(this)
        children.forEach{
            it.forEachDepthFirst(visit)
        }
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


    val Drinks =TreeNode("BestServedCold").run {

        alcohol.add(alcohol)
        brandy.add(brandy)
        whisky.add(whisky)
        softDrinks.add(softDrinks)
    }

    val tree = makeBeverage()
    tree.forEachDepthFirst {println(it.value)}
}