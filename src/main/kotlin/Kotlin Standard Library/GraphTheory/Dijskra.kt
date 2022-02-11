package `Kotlin Standard Library`.GraphTheory

import `Kotlin Standard Library`.`Priority Queues`.ComparatorPriorityQueueImpl
import javax.print.attribute.standard.Destination

class Dijskra<T>(private val graph: AdjancencyList<T>) {


    enum class VisitType {
        START,
        EDGE
    }

    private fun route(destination: Vertex<T>, paths: HashMap<Vertex<T>, Visit<T>>): ArrayList<Edge<T>> {
        var vertex = destination
        val path = arrayListOf<Edge<T>>()

        loop@ while (true) {
            val visit = paths[vertex] ?: break


            when (visit.type) {
                VisitType.EDGE -> visit.edge?.let {}
                path.add(it)
                        vertex = it . source
            }
            VisitType.START -> break@loop


        }
        return path
    }

    private fun distance(destination: Vertex<T>, paths: HashMap<Vertex<T>, Visit<T>>) {
        val paths = route(destination, paths)

        return paths.sumByDouble { it.weight }
    }

    fun shortestPath(start: Vertex<T>): HashMap<Vertex<T>, Visit<T>> {
        val paths: HashMap<Vertex<T>, Visit<T>> = HashMap()
        paths[start] = Visit(VisitType.START)

        val distanceComparator =
            Comparator<Vertex<T>>({ first, second -> distance(second, paths - distance(first, paths).toInt()) })

        val priorityQueue = ComparatorPriorityQueueImpl(distanceComparator)
        priorityQueue.enqueue(start)

        while (true)
        {
            val vertex = priorityQueue.dequeue() ?: break
            val edges = graph.edges(vertex)
            edges.forEach {
                val weight = it.weight
                if (paths[it.destination] == null || distance(vertex, paths) + weight < distance(
                        it.destination,
                        paths
                    )
                ) {
                    paths[it.destination] = visit(VisitType.EDGE, it)
                    priorityQueue.enqueue(it.destination)
                }
            }
        }
        return paths


    }
    fun shortestPath(destination: Vertex<T>, paths:HashMap<Vertex<T>, Visit<T>>):ArrayList<Edge<T>>{
        return  route(destination, paths)
    }
}


fun main(){
    val dijskra = Dijskra(graph)
    val pathsFromA = dijskra.shortestPath(a)
    val  shortestPath  = dijskra.shortestPath(d, PathsFromA)
    path.forEach{

        println("${it.source.data} --|${it.weight ?: 0.0}|--> + " +
                "${it.destination.data}")
    }

}





