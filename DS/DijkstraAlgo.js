// class PriorityQueue {
//     constructor() {
//         this.values = [];
//     }
//     enqueue(val, priority) {
//         this.values.push({ val, priority });
//         this.sort();
//     }
//     dequeue() {
//         return this.values.shift();
//     }
//     sort() {
//         this.values.sort((a, b) => a.priority - b.priority)
//     }
// }


class Node {
    constructor(val, priority) {

        this.val = val;
        this.priority = priority
    }
}

class PriorityQueue {
    constructor() {
        this.values = []

    }
    enqueue(val, priority) {
        let node = new Node(val, priority)
        this.values.push(node);
        if (this.values.length === 1) {

            return this;
        }
        else {
            let startIdx = this.values.length - 1;
            while (startIdx > 0) {
                let parentIdx = Math.floor((startIdx - 1) / 2)
                if (this.values[parentIdx].priority > this.values[startIdx].priority) {
                    let temp = this.values[parentIdx];
                    this.values[parentIdx] = this.values[startIdx]
                    this.values[startIdx] = temp;
                    startIdx = parentIdx;
                }
                else
                    break;
            }
        }

    }
    dequeue() {
        const min = this.values[0];
        const end = this.values.pop();
        if (this.values.length > 0) {
            this.values[0] = end;
            this.sinkDown();
        }
        return min;
    }
    sinkDown() {
        let idx = 0;
        const length = this.values.length;
        const element = this.values[0];
        while (true) {
            let leftChildIdx = 2 * idx + 1;
            let rightChildIdx = 2 * idx + 2;
            let leftChild, rightChild;
            let swap = null;

            if (leftChildIdx < length) {
                leftChild = this.values[leftChildIdx];
                if (leftChild.priority < element.priority) {
                    swap = leftChildIdx;
                }
            }
            if (rightChildIdx < length) {
                rightChild = this.values[rightChildIdx];
                if (
                    (swap === null && rightChild.priority < element.priority) ||
                    (swap !== null && rightChild.priority < leftChild.priority)
                ) {
                    swap = rightChildIdx;
                }
            }
            if (swap === null) break;
            this.values[idx] = this.values[swap];
            this.values[swap] = element;
            idx = swap;
        }
    }
}

class WeightedGraph {
    constructor() {
        this.adjacencyList = {}
    }
    addVertex(vertex) {
        if (!this.adjacencyList[vertex]) this.adjacencyList[vertex] = []
    }
    addEdge(vertex1, vertex2, weight) {
        this.adjacencyList[vertex1].push({ node: vertex2, weight: weight })
        this.adjacencyList[vertex2].push({ node: vertex1, weight: weight })
    }
    Dijkstsra(start, finish) {
        const nodes = new PriorityQueue();
        const distances = {};
        const previous = {};
        let smallest;
        let path = []; //to retrun at end
        // build up initial state

        for (let vertex in this.adjacencyList) {
            if (vertex === start) {
                distances[vertex] = 0;
                nodes.enqueue(vertex, 0)
            }
            else {
                distances[vertex] = Infinity;
                nodes.enqueue(vertex, Infinity);
            }
            previous[vertex] = null;
        }
        // as long as there is something to visit
        while (nodes.values.length) {
            smallest = nodes.dequeue().val;
            if (smallest === finish) {
                //WE RE DONE
                // BUILD UP PATH TO RETRUN AT END;
                while (previous[smallest]) {
                    path.push(smallest)
                    smallest = previous[smallest];

                }
                break;
            }
            if (smallest || distances[smallest] != Infinity) {
                for (let neighbour in this.adjacencyList[smallest]) {
                    // find neighbouring node
                    let nextNode = this.adjacencyList[smallest][neighbour]
                    // console.log(nextNode)
                    // calculate new distance to neighbouring node
                    let candidate = distances[smallest] + nextNode.weight;
                    let nextNeighbour = nextNode.node;
                    if (candidate < distances[nextNeighbour]) {
                        // updating new smallest distance to neighbour
                        distances[nextNeighbour] = candidate;
                        // updating previous-How we got to neighbour
                        previous[nextNeighbour] = smallest;
                        // enqueue in priority queue with new priority
                        nodes.enqueue(nextNeighbour, candidate);
                    }
                }
            }
        }
        return path.concat(smallest).reverse();
    }
}
let g = new WeightedGraph();
g.addVertex("A")
g.addVertex("B")
g.addVertex("C")
g.addVertex("D")
g.addVertex("E")
g.addVertex("F")
g.addVertex("G")


g.addEdge("A", "B", 4)

g.addEdge("A", "C", 2)
g.addEdge("A", "G", 3)
g.addEdge("B", "D", 2)
g.addEdge("C", "E", 4)
g.addEdge("D", "E", 3)
g.addEdge("D", "F", 1)
g.addEdge("E", "F", 1)


console.log(g.Dijkstsra("A", "F"))