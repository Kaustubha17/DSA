/*Keep comparing two adjacent values if larger is first then swap and keep swapping until the
largest is moved to the end
o  ...O
Arr->3,5,2,45.23

Step 1. 3,2,5,23,45
Step 2. 2,3,5,23,45

*/


function bubbleSort(arr) {

    for (let i = arr.length - 1; i > 0; i--) {
        for (let j = 0; j < i; j++) {
            if (arr[j] > arr[j + 1]) {
                let temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;

            }
            console.log(arr)
        }
    }
    return arr;
}

console.log(bubbleSort([3, 5, 2, 45, 23]))