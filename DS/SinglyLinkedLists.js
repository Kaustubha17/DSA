// Linked list is collection of nodes
// node stores value and reference to next node


class Node {
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}

class SinglyLinkedList {
    constructor() {
        this.length = 0;
        this.tail = null;
        this.head = null;

    }
    push(val) {
        var newNode = new Node(val);

        if (!this.head) {
            this.head = newNode;
            this.tail = this.head;

        }
        else {
            this.tail.next = newNode
            this.tail = newNode
        }
        this.length++;
        return this;
    }
    pop() {
        if (!this.head) return undefined;
        var current = this.head;
        var newTail = current;
        while (current.next) {
            newTail = current;
            current = current.next;
        }
        this.tail = newTail;
        console.log(this.tail)
        this.tail.next = null;
        this.length--;
        if (this.length === 0) {
            this.head = null;
            this.tail = null;
        }
        return current;
    }
    shift() {
        if (!this.head) return undefined;
        let currentHead = this.head;
        this.head = currentHead.next;
        this.length--;
        if (this.length === 0) {

            this.tail = null;
        }
        return currentHead;
    }
    unshift(val) {
        let newNode = new Node(val);
        if (!this.head) {
            this.head = newNode
            this.tail = this.head
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
        return this;

    }
    get(index) {
        if (index < 0 || index >= this.length)
            return null;
        let currNode = this.head;
        while (index !== 0) {
            currNode = currNode.next
            index--;
        }
        return currNode

    }
    set(index, value) {

        var foundNode = this.get(index)
        if (foundNode) {
            foundNode.val = value;
            return true;
        }
        return false;
    }
    insert(index, val) {
        if (index < 0 || index > this.length)
            return false
        else if (index == this.length) {

            return this.push(val)
        }
        else if (index == 0) {
            return this.unshift(val)
        }
        else {
            let newNode = new Node(val);
            let currentNode = this.get(index);
            let prevNode = this.get(index - 1);
            prevNode.next = newNode;
            newNode.next = currentNode;
            this.length++;
            return this
        }

    }
    remove(index) {
        if (index < 0 || index >= this.length) return undefined;
        if (index === 0) return this.shift();
        if (index === this.length - 1) return this.pop();

        var previousNode = this.get(index - 1);
        var removed = previousNode.next;
        previousNode.next = removed.next;
        this.length--;
        return removed;

    }
    print() {
        var arr = [];
        var current = this.head
        while (current) {
            arr.push(current.val)
            current = current.next
        }
        console.log(arr)
    }
    reverse() {
        let node = this.head
        this.head = this.tail
        this.tail = node;
        var next;
        var prev = null;
        for (let i = 0; i < this.length; i++) {
            next = node.next
            node.next = prev;
            prev = node;
            node = next;
        }
        return this;
    }

}
// var first = new Node("Hi");
// first.next = new Node("there")
// first.next.next = new Node("How")
// first.next.next.next = new Node("are")
// first.next.next.next.next = new Node("you")
// console.log(first)

var list = new SinglyLinkedList()
list.push("Hello")
list.push("there")
// list.push("!")
// list.push("sdf")
// console.log(list)
// console.log(list.pop())
// console.log(list)
// list.shift()
// list.shift()
// list.unshift("!")

console.log(list.reverse())