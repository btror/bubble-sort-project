var list = [0, 3, 3, 1, -2, -4];
console.log("unsorted: " + list);

function bubbleSort(list) {
    for (i = 0; i < list.length - 1; i++) {
        for (j = 0; j < list.length - i - 1; j++) {
            if (list[j] > list[j + 1]) {
                var temp = list[j];
                list[j] = list[j + 1];
                list[j + 1] = temp;
            }
        }
    }
}

bubbleSort(list);

console.log("sorted: " + list);
