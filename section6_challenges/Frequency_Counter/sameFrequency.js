function sameFrequency(a, b) {
    let freq_a = {};
    let freq_b = {};

    while (a != 0 || b != 0) {
        let unitOfa = a % 10;
        let unitOfb = b % 10;
        if (!freq_a[unitOfa]) {
            freq_a[unitOfa] = 1;
        }
        else {
            freq_a[unitOfa]++;

        }

        if (!freq_b[unitOfb]) {
            freq_b[unitOfb] = 1;
        }
        else {
            freq_b[unitOfb]++;

        }

        a = Math.floor(a / 10);
        b = Math.floor(b / 10);
    }


    for (digit in freq_a) {
        if (!freq_b[digit]) {
            return false;
        }
        else if (freq_a[digit] != freq_b[digit]) {
            return false;
        }
    }

    return true;


}
console.log(sameFrequency(182, 281))