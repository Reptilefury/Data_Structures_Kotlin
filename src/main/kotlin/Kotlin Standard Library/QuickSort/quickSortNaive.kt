package `Kotlin Standard Library`.QuickSort


fun <T : Comparable<T>> List<T>.quickSortNaive(): List<T> {
    if (this.size < 2) return this
    val pivot = this[this.size / 2]
    val less = this.filter { it < pivot }
    val equal = this.filter { it == pivot }
    val greater = this.filter { it > pivot }
    return less.quickSortNaive() + equal.quickSortNaive() + greater.quickSortNaive()
}
