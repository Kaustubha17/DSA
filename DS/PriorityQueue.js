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

let min = new PriorityQueue();
min.enqueue(1, 3);
min.enqueue(1, 2);
min.enqueue(1, 1);
min.dequeue()
console.log(min)