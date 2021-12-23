package `Kotlin Standard Library`.Trees

class TreeNode<T>(val value: T){
    private val children:MutableList<TreeNode<T>> = mutableListOf()
    fun add(child:TreeNode<T>) = children.add(child)
}
fun main(){
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
}