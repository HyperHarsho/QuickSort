package com.hype;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class App {
    public static int loop = 0;
    public static Map<Integer, Integer> data = new HashMap<>();

    // Swapping two elements
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Sorts by creating partition
    public static int partition(int arr[], int high, int low) {
        int p = arr[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < p) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Sorts the array
    public static void quickSort(int arr[], int high, int low) {
        if (low < high) {
            loop++;
            int p = partition(arr, high, low);

            quickSort(arr, p - 1, low);
            quickSort(arr, high, p + 1);
        }
    }

    // Print the array
    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // Generates a random array of size
    public static int[] randomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            Random rand = new Random();
            arr[i] = rand.nextInt(size);
        }
        return arr;
    }

    // Creates a map of length of array(size) and average(set) of number of loop
    // it took to sort a random array each time
    public static void dataMap(int size, int set) {
        int times = 0;
        int avg = 0;
        int arr[];
        for (int i = 1; i <= size; i++) {
            data.put(i, avg);
        }
        for (int i = 1; i <= set; i++) {
            for (int j = 1; j <= size; j++) {
                loop = 0;
                arr = randomArray(j + 1);
                quickSort(arr, j, 0);
                avg = (data.get(j) + loop);
                data.put(j, avg);
                times++;
                System.out.println(times);
            }
        }
        for (int i = 1; i <= size; i++) {
            avg = (int)Math.ceil(data.get(i) / set);
            data.put(i, avg);
        }
        System.out.println("Length \t Loops");
        for (Map.Entry<Integer, Integer> m : data.entrySet()) {
            System.out.println(m.getKey() + " \t " + m.getValue());
        }
    }

    public static void main(String[] args) {
        dataMap(1000, 10);
        DataChart.Chart();
    }
}