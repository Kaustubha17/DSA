// Graphs=Nodes+Connections
/**
 * KeyTerms
 * 1.Vertex/Node
 * 2.Edge
 * 
 * 
 * 1.Directed Graphs
 * 2.Undirected graphs
 * 3.Weighted graphs
 * 4.Unweighted graphs
 */
// Adjacency Matrix
// Adjacency List
class Graph {
    constructor() {
        this.adjacencyList = {}
    }
    addVertex(vertex) {
        if (!this.adjacencyList[vertex])
            this.adjacencyList[vertex] = []
    }
    addEdges(vertex1, vertex2) {
        if (this.adjacencyList[vertex1] && this.adjacencyList[vertex2]) {
            this.adjacencyList[vertex1].push(vertex2)
            this.adjacencyList[vertex2].push(vertex1)
        }
    }
    removeEdge(v1, v2) {
        this.adjacencyList[v1] = this.adjacencyList[v1].filter(v => v != v2)
        this.adjacencyList[v2] = this.adjacencyList[v2].filter(v => v != v1)
    }
    removeVertex(vertex) {
        while (this.adjacencyList[vertex].length) {
            this.removeEdge(vertex, this.adjacencyList[vertex][0])
        }
        delete this.adjacencyList[vertex]

    }
}

let g = new Graph()
g.addVertex("Hello")
g.addVertex("G")
g.addEdges("Hello", "G")
g.addVertex("How")
g.addEdges("Hello", "How")
// g.removeEdge("Hello", "G")
g.removeVertex("Hello")
console.log(g)