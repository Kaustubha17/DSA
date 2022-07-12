/**Works with integers */
function getDigit(number, pos) {
    return Math.floor(Math.abs(number) / Math.pow(10, pos)) % 10
}

function digitCount(num) {
    if (num == 0) return 1;
    return Math.floor(Math.log10(Math.abs(num))) + 1;
}

function mostDigits(arr) {
    let max = -Infinity;
    for (let i = 0; i < arr.length; i++) {
        if (digitCount(arr[i]) > max) {
            max = digitCount(arr[i])
        }
    }
    return max;
}

function radixSort(nums) {
    let maxDigitsCount = mostDigits(nums)
    for (let k = 0; k < maxDigitsCount; k++) {
        let digitBuckets = Array.from({ length: 10 }, () => [])
        for (let i = 0; i < nums.length; i++) {
            digitBuckets[getDigit(nums[i], k)].push(nums[i]);

        }
        nums = [].concat(...digitBuckets)

    }

    return nums
}

console.log(radixSort([12345, 4]))