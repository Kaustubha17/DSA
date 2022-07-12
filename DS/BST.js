// Root -top node in a tree
// Child- A node directly connected to another node when moving away from the root
// Parent- the converse notion of a child
// Siblings  -A group of nodes with the same parent
// Leaf- a node with no children
// Edge-The connection between one node and another

const { acceptsLanguages } = require("express/lib/request");

/** BST
 * 1.Every parent node has at mot two children
 * 2.Every node to the left of a parent node is always less than the parent
 * 3.Every node to the right of a parent node is always greater than the parent 
*/
class Node {
    constructor(value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}


class BinarySearchTree {
    constructor() {
        this.root = null;
    }

    insert(value) {
        let node = new Node(value);
        if (!this.root) {
            this.root = node
            return this;
        }
        else {
            var current = this.root;
            while (true) {
                if (value === current.value) return undefined;
                if (value < current.value) {
                    if (current.left === null) {
                        current.left = node;
                        return this;
                    }
                    else {
                        current = current.left
                    }
                }
                else if (value > current.value) {
                    if (current.right === null) {
                        current.right = node;
                        return this;
                    }
                    else {
                        current = current.right;
                    }
                }
            }
        }
    }



    find(value) {
        let current = this.root
        if (!this.root)
            return false;

        while (current) {
            if (value === current.value)
                return true;
            if (value > current.value) {
                current = current.right
            } else {
                current = current.left;
            }

        }
        return false;
    }
}

var tree = new BinarySearchTree();
// tree.root = new Node(10);
// tree.root.left = new Node(6);
// tree.root.right = new Node(11);
tree.insert(10)
tree.insert(5)
tree.insert(13)
tree.insert(4)
tree.insert(6)
tree.insert(7)
tree.insert(7)
console.log(tree.find(7))