function binarySearch(arr, target) {
    let start = 0;
    let end = arr.length - 1;
    let mid = Math.floor((start + end) / 2)
    // if (target < arr[start] || target > arr[end]) {
    //     return -1;
    // }
    while (start < end) {
        if (arr[mid] === target) {
            return mid;
        }
        else if (arr[start] === target) {
            return start;
        }
        else if (arr[end] === target) {
            return end
        }

        else if (target > arr[mid]) {
            start = mid + 1;

        }
        else if (target < arr[mid]) {
            end = mid - 1;

        }
        mid = Math.floor((start + end) / 2);
        console.log("start:", start, " ", "end:", end)
    }

    return -1;
}

console.log(binarySearch([5, 6, 10, 13, 14, 28, 30, 34, 35, 37, 40, 44, 64, 79, 84, 86, 95, 96, 98, 99], 995))