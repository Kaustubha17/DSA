function averagePair(arr, target) {

    let sumOfPairs = 2 * target;

    let i = 0;
    let j = arr.length - 1;
    for (; i < j; i++) {
        if (arr[i] + arr[j] == sumOfPairs) {
            return true;
        }
        else if (arr[i] + arr[j] <= sumOfPairs) {
            continue;
        }
        else if (arr[i] + arr[j] >= sumOfPairs) {
            j--;
        }
    }
    return false;
}

console.log(averagePair([1, 2, 3], 2.6))

