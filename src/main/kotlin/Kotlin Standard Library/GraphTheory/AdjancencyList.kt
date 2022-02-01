package `Kotlin Standard Library`.GraphTheory


class AdjancencyList<T> : Graph<T> {

    private val adjancencies: HashMap<Vertex<T>>, ArrayList<Edge<T>> = Hashmap()

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(adjancencies.count, data)
        adjancencies[vertex] = ArrayList()
        return vertex
    }

    override fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {


    }

    override fun edges(source: Vertex<T>): ArrayList<Edge<T>> {
        adjancencies[source] ?: arrayListOf<T>()
    }

    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? {
        return edges(source).firstOrNull { it.destination == destination }?.weight
    }

    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        val edge = Edge(source, destination, weight)
        adjancencies[source]?.add(edge)
    }

    override fun toString(): String {
        return buildString {

            adjancencies.forEach { (vertex, edges) ->
                val edgeString = edges.joinToString { it.destination.data.toString() }

                append("${vertex.data} ----> [$edgeString]\n")
            }
        }
    }
}

fun main() {
    val graph = AdjancencyList<String>()
    val singapore = graph.createVertex("Singapore")
    val Tokyo = graph.createVertex("Tokyo")
    val Detroit = graph.createVertex("Detroit")
    val HongKong = graph.createVertex("HongKong")
    val sanFrancisco = graph.createVertex("San Francisco")
    val austinTexas = graph.createVertex("Austin Texas")
    val washingtonDc = graph.createVertex("Washington DC")
    val Seattle  = graph.createVertex("Seattle")
    graph.addUndirectedEdge(singapore, HongKong , 300.0)
    graph.addUndirectedEdge(singapore,Tokyo , 500.0)
    graph.addUndirectedEdge(HongKong, Tokyo , 250.0)
    graph.addUndirectedEdge(HongKong, sanFrancisco, 600.0)
    graph.addUndirectedEdge(Tokyo, Detroit, 450.0)
    graph.addUndirectedEdge(Tokyo, washingtonDc, 300.0)
    graph.addUndirectedEdge(Detroit, austinTexas , 50.0)
    graph.addUndirectedEdge(austinTexas, sanFrancisco, 297.0)
    graph.addUndirectedEdge(austinTexas, washingtonDc,292.0)
    graph.addUndirectedEdge(washingtonDc,Seattle, 277.0)
    graph.addUndirectedEdge(washingtonDc,sanFrancisco,337.0)
    graph.addUndirectedEdge(sanFrancisco, Seattle , 218.0)
    println(graph)
    println(graph.weight(singapore,Tokyo))

}


















