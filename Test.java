public class Test {
    public static void main(String[] args){
        int[] list = {67, 33, 21, 84, 49, 50, 75};
        print(list);
        System.out.print("Selection sort: ");
        Sort.selectionSort(list);
        print(list);

        // insertion
        shuffle(list);
        print(list);
        System.out.print("Insertion sort: ");
        Sort.insertionSort(list);
        print(list);

        // insertion
        shuffle(list);
        print(list);
        System.out.print("Bubble sort: ");
        Sort.bubbleSort(list);
        print(list);

        // insertion
        shuffle(list);
        print(list);
        System.out.print("Merge sort: ");
        Sort.mergeSort(list);
        print(list);
    }

    public static void print(int[] list){
        for(int value: list){
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void shuffle(int[] list){
        for(int i = 0; i < list.length; i++){
            int randIndex = (int)(Math.random() * list.length);
            int temp = list[i];
            list[i] = list[randIndex];
            list[randIndex] = temp;
        }
    }
}
