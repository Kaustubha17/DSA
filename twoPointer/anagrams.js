function validAnagram(a, b) {
    if (a.length != b.length) {
        return false;
    }
    let a_obj = {}
    let b_obj = {}
    // adding letters in a_obj
    for (letter of a) {
        if (!a_obj[letter]) {
            a_obj[letter] = 1;
        }
        else {
            a_obj[letter]++;
        }
    }

    // adding letters in b_obj
    for (letter of b) {
        if (!b_obj[letter]) {
            b_obj[letter] = 1;
        }
        else {
            b_obj[letter]++;
        }
    }
    for (letter in a_obj) {
        if (!b_obj[letter]) {
            return false;
        }
        if (a_obj[letter] != b_obj[letter])
            return false;
    }
    // console.log(a_obj);
    // console.log(b_obj)
    return true;


}
console.log(validAnagram('asd', 'dsa'))