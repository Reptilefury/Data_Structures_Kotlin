package `Kotlin Standard Library`.GraphTheory

import `Kotlin Standard Library`.size

class AdjancencyMatrix<T> : Graph<T> {
    val vertices = ArrayList<Vertex<T>>()
    val weights = ArrayList<Double?>()
    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        return  weights[source.index][destination.index]
    }

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(vertices.count(), data)
        vertices.add(vertex)
        weights.forEach {
            it.add(null)
        }
        weights.add(arrayListOf())
        return vertex
    }
    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        val vertex = Vertex(vertices.count(), data)
        vertices.add(vertex)
        weights.forEach {
            it.add(null)
        }
        val row = ArrayList<Double?>(vertices.count())
        repeat(vertices.count()) {
            row.add(null)
        }
        weights.add(row)
        return vertex
    }
    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> {
        val edges = arrayListOf<Edge<T>>()
        (0 until weights.size).forEach {
            column ->
            val weight = weights[source.index][column]
            if(weight != null){
                edges.add(Edge(source, vertices[column], weight))
            }
        }
    return  edges
    }
}