// Heaps are another type of tree
// There are many types of Heaps
// We are going to use Binary Heaps which again  can be classified into min and max heaps
// In max heap parent is always greater than the children
// In min heap parent is always less than children

//Implementing MaxHeap using arrays where children index =2(parentIndex)+1 and 2(parentIndex)+2
//                                    and parent index=Math.floor((childrenIndex-1)/2)
class MaxBinaryHeap {
    constructor() {
        this.values = []
    }
    push(val) {
        this.values.push(val)
        if (this.values.length === 1) {
            return this;
        }
        else {
            let init = this.values.length - 1;
            let parentIndex = Math.floor((init - 1) / 2)
            //bubble up logic
            while (this.values[init] > this.values[parentIndex] && init >= 0) {
                let temp = this.values[init];
                this.values[init] = this.values[parentIndex];
                this.values[parentIndex] = temp;
                init = parentIndex;
                parentIndex = Math.floor((init - 1) / 2)

            }
            return this;
        }
    }
    extractMax() {
        if (this.values.length === 0)
            return undefined;

        let max = this.values[0];
        const end = this.values.pop();
        this.values[0] = end;
        // sink down
        this.sinkDown()
        return max;
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
                if (leftChild > element) {
                    swap = leftChildIdx;

                }
            }

            if (rightChildIdx < length) {
                rightChild = this.values[rightChildIdx];
                if (
                    (swap === null && rightChild > element) || (!swap && rightChild > leftChild)) {

                    swap = rightChildIdx;
                }
            }
            if (swap == null)
                break;

            this.values[idx] = this.values[swap];
            this.values[swap] = element;
            idx = swap;
        }
    }

}

let newHeap = new MaxBinaryHeap()
newHeap.push(10);
newHeap.push(2);
newHeap.push(20);
newHeap.push(09);
newHeap.push(11);
newHeap.push(14);
newHeap.push(13);
console.log(newHeap)
console.log(newHeap.extractMax())
console.log(newHeap)
