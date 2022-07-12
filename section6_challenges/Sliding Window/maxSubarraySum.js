function maxSubarraySum(arr, numbers) {

    if (arr.length < numbers)
        return null;

    let maxSum = 0;
    if (arr.length == numbers) {
        for (let i = 0; i < numbers; i++) {
            maxSum += arr[i];

        }
        return maxSum;
    }



    for (let i = 0; i < numbers; i++) {
        maxSum += arr[i];
    }
    let temSum = maxSum;
    for (let i = 1; i < arr.length - numbers + 1; i++) {

        // console.log(`tempSum: ${temSum} arr[i-1] ${arr[i - 1]} arr[i+1] ${arr[i + numbers - 1]}`)

        temSum = temSum - arr[i - 1] + arr[i + numbers - 1];
        // console.log(`tempSum: ${temSum} arr[i-1] ${arr[i - 1]} arr[i+1] ${arr[i + numbers - 1]}`)



        if (temSum > maxSum)
            maxSum = temSum

    }
    return maxSum


}

console.log(maxSubarraySum([2, 3], 3))