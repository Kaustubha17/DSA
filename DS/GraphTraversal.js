class Graph {
    constructor() {
        this.adjacencyList = {}
    }
    addVertex(val) {
        if (!this.adjacencyList[val]) {
            this.adjacencyList[val] = [];
        }
    }
    addEdge(v1, v2) {
        this.adjacencyList[v1].push(v2);
        this.adjacencyList[v2].push(v1);
    }
    removeEdge(v1, v2) {

        this.adjacencyList[v1] = this.adjacencyList[v1].filter(v => v != v2)
        this.adjacencyList[v2] = this.adjacencyList[v2].filter(v => v != v1)
    }
    removeVertex(v1) {
        while (this.adjacencyList[v1].length) {

            this.removeEdge(v1, this.adjacencyList[v1][0])
        }
        delete this.adjacencyList[v1]
    }
    graphDFSRecursive(val) {
        let resultList = [];
        let visited = {};
        const adjacencyList = this.adjacencyList;
        function helper(vertex) {
            if (!vertex)
                return;
            resultList.push(vertex);
            visited[vertex] = true;

            for (let i = 0; i < adjacencyList[vertex].length; i++) {

                if (!visited[adjacencyList[vertex][i]])
                    helper(adjacencyList[vertex][i])
            }
        }
        helper(val);
        return resultList;
    }

    graphDFSIter(vertex) {
        let visited = {}
        let result = [];
        let callStack = [];
        visited[vertex] = true;

        callStack.push(vertex);
        let currentVertex;
        while (callStack.length) {
            console.log(callStack)
            currentVertex = callStack.pop();
            result.push(currentVertex);
            this.adjacencyList[currentVertex].forEach(neighbour => {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    callStack.push(neighbour)
                }
            });
        }
        return result;

    }
    BFS(vertex) {
        let queue = [];
        let visited = {};
        let result = [];

        queue.push(vertex);
        visited[vertex] = true;
        let currentVertex;
        while (queue.length) {
            console.log(currentVertex)
            currentVertex = queue.shift();
            result.push(currentVertex);
            this.adjacencyList[currentVertex].forEach(v => {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.push(v);
                }
            })

        }
        return result;
    }


}


let g = new Graph();

g.addVertex("A")
g.addVertex("B")
g.addVertex("C")
g.addVertex("D")
g.addVertex("E")
g.addVertex("F")
g.addVertex("G")


g.addEdge("A", "B")
g.addEdge("A", "C")
g.addEdge("A", "G")
g.addEdge("B", "D")
g.addEdge("C", "E")
g.addEdge("D", "E")
g.addEdge("D", "F")
g.addEdge("E", "F")
console.log(g.BFS("A"))