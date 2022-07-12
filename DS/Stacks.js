// Using arrays --inefficient
// var stack = [];

// stack.push("a");
// stack.pop();
// stack.unshift("sd")
// stack.shift()

//Using Linked List

class Node {
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}


class Stack {
    constructor(val) {
        this.length = 0;
        this.first = null;
        this.last = null;
    }
    push(val) {
        let node = new Node(val);
        if (!this.first) {
            this.first = node;
            this.last = this.first;
        }
        else {
            node.next = this.first;
            this.first = node;
        }
        this.length++;
        return this;
    }

    pop() {
        if (!this.first)
            return undefined;
        let retrunedNode = this.first;
        if (this.length === 1) {

            this.first = null;
            this.last = null;
        }
        else {
            this.first = retrunedNode.next;
            retrunedNode.next = null
        }
        this.length--;
        return retrunedNode.val
    }
}

let stack = new Stack();
stack.push("a")
stack.push("b")
stack.push("c")
console.log(stack.pop())
console.log(stack.pop())
console.log(stack.pop())
console.log(stack.pop())
console.log(stack)