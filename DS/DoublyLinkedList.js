class Node {
    constructor(val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    push(val) {
        let node = new Node(val)
        if (!this.head) {
            this.head = node;
            this.tail = this.head;

        } else {
            this.tail.next = node
            node.prev = this.tail
            this.tail = node
        }
        this.length++;
        return this;
    }
    pop() {
        if (!this.head) {
            return undefined;
        }

        else if (this.length == 1) {
            this.head = null;
            this.tail = null;
        }
        else {
            var poppedNode = this.tail;
            this.tail = poppedNode.prev;
            this.tail.next = null;
            poppedNode.prev = null;
        }
        this.length--;
        return poppedNode;
    }

    shift() {
        if (!this.head) {
            return undefined;
        }
        else if (this.length == 1) {
            this.pop()
        }
        else {
            var shifted = this.head;
            this.head = shifted.next;
            this.head.prev = null;
            shifted.next = null;

        }
        this.length--;
        return this;
    }
    unshift(val) {
        if (!this.head) {
            this.push(val)
        }
        else {
            let newHead = new Node(val);
            newHead.next = this.head;
            this.head.prev = newHead
            this.head = newHead;
            this.length++;
        }

        return true;
    }
    get(index) {
        // console.log(index, this.length)
        if (!this.head) {
            return undefined
        }
        if (index < 0 || index >= this.length) {
            // console.log(this.length)
            return undefined;
        }
        else if (index < (this.length / 2)) {
            console.log("Working from start")
            let node = this.head;
            while (index) {
                node = node.next;
                index--;
            }
            return node;
        }
        else {
            let node = this.tail;
            console.log("Working from end")
            while (this.length - index - 1) {
                node = node.prev;
                index--;
            }
            return node;
        }
    }
    set(index, val) {
        let node = this.get(index);
        // return node;
        if (node) {
            node.val = val;
            return true;
        }
        return false;
    }
    insert(index, val) {
        let nextNode = this.get(index);
        if (index == 0) {
            this.unshift(val)
            // this.length++
            return true;
        }
        if (index == this.length) {
            this.push(val);
            // this.length++
            return true;
        }

        if (nextNode) {
            let node = new Node(val);
            node.next = nextNode
            node.prev = nextNode.prev
            nextNode.prev.next = node
            nextNode.prev = node;
            this.length++;
            return true;
        }
        return false;
    }
    remove(index) {

        if (index < 0 || index >= this.length) {
            return undefined;
        }
        if (index == 0) {
            if (this.shift())
                return true;

            return false;
        }
        if (index == this.length - 1) {
            if (this.pop())
                return true;

            return false;
        }

        let node = this.get(index);
        if (node) {
            node.prev.next = node.next;
            node.next.prev = node.prev
            node.next = null;
            node.prev = null;
            this.length--;
            return true;
        }
        return false;

    }

}

let a = new DoublyLinkedList();
a.push("Hello")
a.push("there")
a.push("!")


console.log(a.remove(0))
console.log(a)

