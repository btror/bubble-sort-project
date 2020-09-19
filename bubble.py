# A simple program that implements bubble sort

def bubble_sort(array):
    print("unsorted list: " + str(array))
    for i in range(len(array) - 1, 0, -1):
        for j in range(i):
            if array[j] > array[j + 1]:
                temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
    print("sorted list: " + str(array))

array = [2, 4, 6, 0, -2, -5, 20, 30]
bubble_sort(array)
