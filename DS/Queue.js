// Using arrays
var q = []
q.push(1)
q.push(2)
q.push(3)
q.shift()
q.shift()
// or can be implemented using unshift and pop

class Node {
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}


class Queue {
    constructor(val) {
        this.length = 0;
        this.first = null;
        this.last = null;
    }
    enqueue(val) {
        let node = new Node(val);
        if (!this.first) {
            this.first = node;
            this.last = this.first;
        }
        else {
            this.last.next = node;
            this.last = node;

        }
        this.length++;
        return this;
    }

    dequeue() {
        if (!this.first)
            return undefined;
        let retrunedNode = this.first;
        if (this.length === 1) {

            this.first = null;
            this.last = null;
        }
        else {
            this.first = null;
            this.first = retrunedNode.next;
        }
        this.length--;
        return retrunedNode.val
    }
}
let qu = new Queue();
qu.enqueue("q")
qu.enqueue("ue")
qu.enqueue("e")
qu.enqueue("u")
qu.enqueue("es")
console.log(qu)
console.log(qu.dequeue())
console.log(qu.dequeue())
console.log(qu.dequeue())
console.log(qu.dequeue())
console.log(qu.dequeue())
// console.log(qu.dequeue())
// console.log(qu.dequeue())