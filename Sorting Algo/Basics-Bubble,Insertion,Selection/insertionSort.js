/**
 * Builds up the sort by gradually creating a larger left half which is always sorted
 */

function insertionSort(arr) {
    for (let i = 1; i < arr.length; i++) {
        let currentVal = arr[i];
        let j = i - 1
        for (; j >= 0 && arr[j] > currentVal; j--) {
            arr[j + 1] = arr[j];
        }
        arr[j + 1] = currentVal
    }

    return arr;
}

console.log(insertionSort([3, 2, 12, 4, 23, 543, 234, 1]))