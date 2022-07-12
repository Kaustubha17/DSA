function mergeSort(arr) {
    // console.log(arr)

    if (arr.length <= 1)
        return arr;
    let mid = Math.floor(arr.length / 2)
    let left = mergeSort(arr.slice(0, mid))
    let right = mergeSort(arr.slice(mid))
    // console.log("left-->", left, "right-->", right)

    return merge(left, right)


}


function merge(arr1, arr2) {

    let i = 0
    let j = 0;
    let arr = []

    while (i < arr1.length && j < arr2.length) {

        if (arr1[i] < arr2[j]) {
            arr.push(arr1[i])
            i++;
        }
        else {
            arr.push(arr2[j])
            j++;
        }
    }

    while (i < arr1.length) {
        arr.push(arr1[i])
        i++;
    }


    while (j < arr2.length) {
        arr.push(arr2[j])
        j++;
    }




    return arr;
}

console.log(mergeSort([3, 2, 1]))
// mergeSort([3, 2, 1])

