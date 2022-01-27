package `Kotlin Standard Library`.GraphTheory

interface Graph<T> {
    fun createVertex(data: T): Vertex<T>
    fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?)
    fun addUndirectexEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?)
    fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?)
    fun edges(source: Vertex<T>): ArrayList<Edges<T>>
    fun weight(source: Vertex<T>, destination: Vertex<T>): Double?
}

enum class EdgeType {
    DIRECTED,
    UNDIRECTED
}