function bubbleSort(arr) {
    let sorted = true;
    for (let i = 0; i < arr.length; i++) {
        for (let j = 1; j < arr.length - i; j++) {
            if (arr[j - 1] > arr[j]) {
                let temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                sorted = false;

            }
            console.log(arr)

        }
        if (sorted)
            return arr;

        sorted = true;
    }
    return arr;
}

console.log(bubbleSort([3, 5, 2, 45, 23]))