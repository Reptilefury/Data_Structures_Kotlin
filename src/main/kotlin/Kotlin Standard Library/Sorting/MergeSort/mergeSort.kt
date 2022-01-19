package `Kotlin Standard Library`.Sorting.MergeSort

fun <T:Comparable<T>> List<T>.mergeSort():List<T>{

    if(this.size < 2) return this
    val middle = this.size /2
    val left = this.subList(middle, this.size)




}