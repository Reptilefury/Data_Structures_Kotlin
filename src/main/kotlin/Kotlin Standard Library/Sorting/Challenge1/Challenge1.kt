package `Kotlin Standard Library`.Sorting.Challenge1

import `Kotlin Standard Library`.swapAt

fun<T:Comparable<T>> MutableList<T>.rightAlign(element:T){
    if (this.size < 2 ) return
    val searchIndex = this.size  - 2
    while (searchIndex >= 0){
        if(this[searchIndex] == element){
            var moveIndex = searchIndex
            while (moveIndex < this.size -1 &&
                    this[moveIndex + 1] != element){
                swapAt(moveIndex, moveIndex + 1)
                moveIndex ++
            }
        }
        searchIndex
    }
}