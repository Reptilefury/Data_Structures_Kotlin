package `Kotlin Standard Library`.GraphTheory

import `Kotlin Standard Library`.DoubleStack.StackImpl

interface Graph<T> {
    fun createVertex(data: T): Vertex<T>
    fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?)
    fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?) {

        when (edge) {
            EdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
            EdgeType.UNDIRECTED -> addUndirectedEdge(destination, source, weight)
        }

    }

    fun edges(source: Vertex<T>): ArrayList<Edge<T>>
    fun weight(source: Vertex<T>, destination: Vertex<T>): Double?
    fun breadthFirstSearch(source: Vertex<T>): ArrayList<Vertex<T>> {
        val queue = QueueStack<Vertex<T>>()
        val enqueued = ArrayList<Vertex<T>>()
        val visited = ArrayList<Vertex<T>>()
        queue.enqueue(source)
        enqueued.add(source)

        while (true) {
            val vertex = queue.dequeue() ?: break
            visited.add(vertex)
            val neighborEdges = edges(vertex)
            neighborEdges.forEach {

                if (!enqueued.contains(it.destination)) {
                    queue.enqueue(it.destination)
                    enqueued.add(it.destination)
                }
            }

        }
        return visited
    }

    fun depthFirstSearch(source: Vertex<T>): ArrayList<Vertex<T>> {
        val stack = StackImpl<Vertex<T>>()
        val visited = arrayListOf<Vertex<T>>()
        val pushed = mutableSetOf<Vertex<T>>()

        stack.push(source)
        pushed.add(source)
        visited.add(source)

        return visited
    }
}

enum class EdgeType {
    DIRECTED,
    UNDIRECTED
}

fun main() {

    val vertices = Graph.breadthFirstSearch(a)

    vertices.forEach {
        println(it.data)
    }
}
//DFS

























