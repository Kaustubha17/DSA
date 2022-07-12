/*
Move the minimum value to front
5,3,4,1,2

1,3,4,5,2
1,2,4,5,3
1,2,3,5,4
1,2,3,4,5

*/
function selectionSort(arr) {

    for (let i = 0; i < arr.length; i++) {

        let minIndex = i;
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIndex]) {

                minIndex = j;
            }
        }
        let temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp
    }
    return arr;
}

console.log(selectionSort([2, 1, 4, 3, 8, 45, 23]))