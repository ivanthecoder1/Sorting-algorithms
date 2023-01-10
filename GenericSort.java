



public class GenericSort {
    // Selection sort (Generic sort)
    public static <E extends Comparable<E>> void selectionSort(E[] list) {
        int minIndex;
        for (int i = 0; i < list.length - 1; i++) {
            E min = list[i];
            minIndex = i;
            for (int j = i; j < list.length; j++) {
                if (list[j].compareTo(min) < 0) {
                    min = list[j];
                    minIndex = j;
                }
            }
            E temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }

    // insertion sort (Generic version)
    public static <E extends Comparable<E>> void insertionSort(E[] list) {
        for (int i = 1; i < list.length; i++) {
            // Insert element i in the sorted sub-list
            E currentVal = list[i];
            int j = i;
            while (j > 0 && currentVal.compareTo((list[j - 1])) < 0) {
                // Shift element (j-1) into element (j)
                list[j] = list[j - 1];
                j--;
            }
            // Insert currentVal at position j
            list[j] = currentVal;
        }
    }

    // Bubble sort (generic version)
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean sorted = false;
        for (int k = 1; k < list.length && !sorted; k++) {
            sorted = true;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i].compareTo(list[i + 1]) > 0) {
                    // swap
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    // Merge sort (generic version)
    public static <E extends Comparable<E>> void mergeSort(E[] list) {
        if (list.length > 1) { // ==1: base case
            Comparable[] firstHalf = (E[]) new Comparable[list.length / 2];
            Comparable[] secondHalf = (E[]) new Comparable[list.length - list.length / 2];
            System.arraycopy(list, 0,
                    firstHalf, 0,
                    list.length / 2);
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0,
                    list.length - list.length / 2);
            mergeSort(firstHalf);
            mergeSort(secondHalf);
            merge((E[]) firstHalf, (E[]) secondHalf, list);
        }
    }

    public static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] list) {
        int list1Index = 0;
        int list2Index = 0;
        int listIndex = 0;
        while (list1Index < list1.length &&
                list2Index < list2.length) {
            if (list1[list1Index].compareTo(
                    list2[list2Index]) < 0)
                list[listIndex++] = list1[list1Index++];
            else
                list[listIndex++] = list2[list2Index++];
        }
        while (list1Index < list1.length)
            list[listIndex++] = list1[list1Index++];
        while (list2Index < list2.length)
            list[listIndex++] = list2[list2Index++];
    }

    // quick sort (generic version)
    public static <E extends Comparable<E>> void quickSort(E[] list) {
        quickSort(list, 0, list.length - 1);
    }

    public static <E extends Comparable<E>> void quickSort(E[] list,
            int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    public static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
        E pivot;
        int index, pivotIndex;
        pivot = list[first];// pivot is the first element
        pivotIndex = first;
        for (index = first + 1; index <= last; index++) {
            if (list[index].compareTo(pivot) < 0) {
                pivotIndex++;
                swap(list, pivotIndex, index);
            }
        }
        swap(list, first, pivotIndex);
        return pivotIndex;
    }

    // O(1)
    public static <E> void swap(E[] list, int index1, int index2) {
        E temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public static <E extends Comparable<E>> void heapSort(E[] list) {
        Heap<E> heap = new Heap<>(); // need file for heap
        for (int i = 0; i < list.length; i++) {
            heap.add(list[i]);
        }
        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }
}
