package `Kotlin Standard Library`

fun <Element : Any> LinkedList<Element>.printInReverse() {
    val stack = StackImpl<Element>()
    for (node in this) {
        stack.push(node)
    }
    var node = stack.pop()
    while (node != null) {
        println(node)
        node = stack.pop()

    }
}


fun String.checkParentheses(): Boolean {
    val stack = StackImpl<Char>()
    for (character in this) {
        when (character) {
            '(' -> stack.push(character)
            ')' -> if (stack.isEmpty) {
                return false
            } else {
                stack.pop()
            }
        }


    }
    return stack.isEmpty

}