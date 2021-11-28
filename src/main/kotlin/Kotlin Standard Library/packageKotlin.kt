package `Kotlin Standard Library`


class Car{
    var model: String? = "Suv"
    var maxSpeed: String = "180KpH"
    val doors:Int = 10
}
val places = listOf("Paris," , "London", "New York")
var places2 = mutableListOf("Paris", "London", "New York")
var mutablePlaces = mutableListOf("Nairobi", "Nakuru", "Mombasa", "Kisumu")
var scores = mutableMapOf("Erick" to 9 , "Mark" to 12 ,"Wayne" to 8)
fun noSideEffecList(name:List<String>){
   println(name)
}

   fun sideEffecList(name:MutableList<String>){
       name.add("Joker!!")
   }
fun mutableVsImmutable(){
    val people = mutableListOf("Chloe" , "Lena", "Anna")
    noSideEffecList(people)
    sideEffecList(people)
    noSideEffecList(people)

}
fun printNames(names:List<String>){
    for(name in names){
        println(name)
    }
}
fun checkFirst(names:List<String>){
    if(names.firstOrNull() != null ){
        println(names.first())
    }else{
        println("No names")
    }
}
fun multiplicationBoard(size:Int){
    for(number in 1..size){
        println("|")
        for(otherNumber in 1..size){
            println("$otherNumber x $number = ${otherNumber * number }")
        }
        println()
    }

}
val numbers = listOf(1,3,56,66,68,80,99, 105,450)
/*fun linearContains(value:Int, numbers:List<Int>):Boolean {
    for(element in numbers){
      if(element == value){
          return true
      }
    }
    return false
}*/
fun linearContains(value:Int, numbers:List<Int>):Boolean{
    for(element in numbers){
        if(element  == value){
            return true
        }
    }
    return false
}
fun pseudoBinaryContains(value:Int, numbers:List<Int>): Boolean {
    if(numbers.isEmpty()) return false
    val middleIndex = numbers.size
    if(value <= numbers[middleIndex]){
        for(index in 0..middleIndex){
            if(numbers[index] == value){
                return true
            }
        }
    } else{
        for(index in middleIndex until numbers.size){
            return true
        }
    }
   return false
}

//https://github.com/Reptilefury/Data_Structures_Kotlin.git
fun sumFromOne(n:Int):Int{
    var result = 0
    for(i in 1..n){
        result += i
    }
    return result
}

fun sumFromTwo(n: Int): Int {
    return (1..n).reduce { sum, element ->
        sum + element
    }
}

fun sumFromThree(n: Int): Int {
    return n * (n + 1) / 2
}

fun printSorted(numbers: List<Int>){
    val sort = numbers.sorted()
    for(element in sort){
        println(element)
    }
}
fun printSorted1(numbers: List<Int>){
    if(numbers.isEmpty()) return

    var currentCount = 0
    var minValue = Int.MIN_VALUE
    for(value in numbers){
        if(value == minValue){
            println(value)
            currentCount += 1
        }
    }
    while(currentCount < numbers.size){
        var currentValue = numbers.maxOrNull()!!
        for(value in numbers){
            if(value < currentValue && value > minValue){
                currentValue = value
            }
        }
        for(value in numbers){
            if(value == currentValue){
                println(value)
                currentCount += 1
            }
        }
        minValue = currentValue
    }

}
fun main() {

    val list = listOf(0,6,8,9,2,5,3,4,1)

    return printSorted(list)

    //var list = listOf(3,2,6)
  //  printSorted(list)
    //return printSorted(list)
    /*  fun multiplicationBoard(size:Int){
          for(number in 1..size){
              println("|")
              for(otherNumber in 1..size){
                  println("$otherNumber x $number = ${otherNumber * number }")
              }
              println()
          }

      }*/

   // var add = sumFromOne(10000)
    //sumFromOne(10000)
  // println(add)
// multiplicationBoard(4)
 /*   multiplicationBoard(4)
    scores["Andrew"] = 0
    mutablePlaces.add("Kiambu")
    mutablePlaces.add(1,"Murang'a")
    println(mutablePlaces)
    fun printCar(car: Car?){
        val isCoupe = car.let{
            (it?.doors!! <= 2)
        }
        if(isCoupe == true){
            println("Coupes are really awsome!!")
        }else{
            println("something went wrong please try again!! ")

        }
    }*/

}

