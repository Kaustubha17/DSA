/**
 * 1. BFS- Breadth-first Search
 * 
 *              10
 *           4      11
 *         3   5   9   12
 * 
 *        [10,4,11,3,5,9,12]
 *          
 * 
 * 2. DFS- Depth-first Search 
 *      a.PreOrder
 *      b.PostOrder
 *      c.Inorder
 */
class Node {
    constructor(val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BST {
    constructor() {
        this.root = null;

    }
    insert(val) {
        let node = new Node(val)
        if (!this.root)
            this.root = node;
        else {
            let current = this.root;
            while (true) {
                if (val > current.val) {
                    if (!current.right) {
                        current.right = node;
                        return this;
                    }
                    else {
                        current = current.right;
                    }
                }
                else {
                    if (!current.left) {
                        current.left = node;
                        return this;
                    }
                    else {
                        current = current.left;
                    }
                }
            }
        }

    }
    BFS() {
        var data = [];
        var queue = [];
        var node = this.root;
        queue.push(this.root);
        while (queue.length) {
            node = queue.shift();
            data.push(node.val);
            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);

        }
        return data;
    }
    DFSPreOrder() {
        var data = []

        function traverse(node) {
            data.push(node.val);
            if (node.left)
                traverse(node.left)
            if (node.right)
                traverse(node.right)
        }
        traverse(this.root)
        return data;
    }

    DFSPostOrder() {
        var data = []

        function traverse(node) {

            if (node.left)
                traverse(node.left)

            if (node.right)
                traverse(node.right)
            data.push(node.val);

        }
        traverse(this.root)
        return data;
    }

    DFSInOrder() {
        var data = []

        function traverse(node) {

            if (node.left)
                traverse(node.left)
            data.push(node.val);
            if (node.right)
                traverse(node.right)


        }
        traverse(this.root)
        return data;
    }


}

let tree = new BST()
tree.insert(10)
tree.insert(6)
tree.insert(3)
tree.insert(8)
tree.insert(9)
tree.insert(11)
tree.insert(15)
tree.insert(20)




console.log(tree.DFSPostOrder())