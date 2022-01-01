val a = 5
val b = 12
var max = -1


fun max(a: Unit, b: Unit) {
   // return if(a>b) a else b
}
/*fun printMax(c:Int, d:Int){
    val  maxValue = max(c,d)
println(maxValue)
}*/
class Box{
    var content:Any? = null
    fun Put(content:Any?){
        this.content =  content
    }
    fun retrieve():Any?{
        return content
    }
    fun isEmpty():Boolean{
        return content == null
    }
}
class box<Int>{
    var content: Int? = null
    fun put(content:Int){
        this.content =  content
    }
    fun retrieve():Int?{
        return content
    }
     fun isEmpty():Boolean{
         return content == null
     }
}
//val boX = box<Int>()
fun main(){

    val boX = box<Int>()
    boX.put(6)
    var x = 10
    while(x>0){
        x--
    }
    do{
        x--
    }while(x>0)
    while(x>0){
        x++
    }
    println("There is light at the end of the tunnel")
    var groupSize = 3
    when(groupSize) {
        1 -> println("Single")
        2 -> println("Pair")
        3 ->{
            println("Trio")
        }
        else -> println("This is either nobody or a some big hell of a group")
    }
    if(a>b){
        max = a
    } else{
        max= b
    }
    println(max)
    for(i in 1..3){
        println(i)
    }
}

