function areThereDuplicates(...at) {
    let freqObj = {}
    let [...originalArray] = at
    console.log(originalArray)
    for (element of originalArray) {
        if (!freqObj[element]) {
            freqObj[element] = 1;
        }
        else {
            freqObj[element]++;
        }
    }

    for (key in freqObj) {
        if (freqObj[key] > 1)
            return true;
    }
    return false
}

console.log(areThereDuplicates('a', 'b', 'c', 'a'))
// console.log(areThereDuplicates(1, 3, 4, 5))