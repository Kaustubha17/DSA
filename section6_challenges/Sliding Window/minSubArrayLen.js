/*function minSubArrayLen(arr, target) {

    let minlength = 0;
    let tempSum = 0;
    for (let i = 0; i < arr.length; i++) {
        tempSum += arr[i];
    }
    if (tempSum < target)
        return 0;
    let sum = tempSum;
    let j = 0;
    let i = arr.length - 1;
    minlength = arr.length;
    while ((i > j) && (tempSum > 0)) {
        console.log(i, " ", j)
        if (arr[i] == sum || arr[j] == sum)
            return 1;
        if ((tempSum - arr[i]) <= (tempSum - arr[j])) {
            tempSum - arr[j];
            if (minlength > (i - j))
                minlength = (i - j)
            j++;


        }
        else {
            tempSum - arr[i];
            i--;
        }
    }


}

console.log(minSubArrayLen([2, 3, 1, 2, 4, 3], 7))
*/

function reverse(str) {

    function reversed(strs, i) {
        console.log(strs)
        if (i == Math.floor((strs.length) / 2)) {
            return;
        }
        console.log(i)
        let chara = strs[i];
        strs[i] = strs[strs.length - i - 1]
        strs[strs.length - i - 1] = chara;

        reversed(strs, i + 1);

        return strs;
    }
    let strs = str.split('');

    return reversed(strs, 0).join('');
}

// console.log(reverse('rithmschool'))
function isPalindrome(str) {
    // console.log(str)
    if (str[0] !== str[str.length - 1])
        return false

    if (str.length == 0 || str.length == 1)
        return true

    return isPalindrome(str.slice(1, -1))
}

// console.log(isPalindrome('abaca'))

function someRecursive(arr, func) {
    if (arr.length === 0)
        return false;

    if (func(arr[0]))
        return true;

    return someRecursive(arr.slice(1), func)
}

const isOdd = val => val % 2 !== 0;
// console.log(someRecursive([4, 6, 8, 9], isOdd))

function flatten(arr) {
    let flattenedArr = [];
    function abc(arr2) {


        if (typeof arr2 === 'number') {
            flattenedArr.push(arr2);
            return;

        }
        else if (typeof arr2 === 'object')
            abc(arr2[0])

    }
    abc(arr);

    return flattenedArr;
    // add whatever parameters you deem necessary - good luck!
}
console.log(flatten([[[[1], [[[2]]], [[[[[[[3]]]]]]]]]]))

