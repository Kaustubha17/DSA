/**
 * counUniqueValues([1,1,1,1,2]) -->2
 * counUniqueValues([1,2,3,4,5,5,5,6,7]) -->7
 * counUniqueValues([]) -->0
 */

function countUniqueValues(arrayOfNumbers) {
    let uniqueValue = 0;
    if (arrayOfNumbers.length === 0)
        return uniqueValue;

    let i = 0;
    let j = i + 1;

    for (; j < arrayOfNumbers.length; j++) {
        if (arrayOfNumbers[i] != arrayOfNumbers[j]) {
            uniqueValue++;
            i = j;
        }
        else {
            continue;
        }

    }
    return uniqueValue + 1;
}

console.log(countUniqueValues([1, 2, 2, 2, 2]))