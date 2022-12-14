package com.hype;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class App {
    public static int loop = 0;
    public static Map<Integer, Integer> data = new HashMap<>();
    public static long start,end,diff=0;

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
        for (int j = low; j < high; j++) {
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
        int avg = 0;
        int arr[];
        for (int i = 1; i <= size; i++) {
            data.put(i, avg);
        }
        for (int i = 1; i <= set; i++) {
            for (int j = 1; j <= size; j++) {
                loop = 0;
                arr = randomArray(j + 1);
                start = System.currentTimeMillis();
                quickSort(arr, j, 0);
                end = System.currentTimeMillis();
                diff+=end-start;
                avg = (data.get(j) + loop);
                data.put(j, avg);
            }
        }
        for (int i = 1; i <= size; i++) {
            avg = (int)Math.ceil(data.get(i) / set);
            data.put(i, avg);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of the array to sort");
        int size = in.nextInt();
        System.out.println("Enter the number of times to sort");
        int set = in.nextInt();
        for(int i = 1; i<=set;i++) {
            diff = 0;
            dataMap(size, i);
            System.out.println(diff+" milliseconds to sort "+size*i+" array of size "+size);
        }
        DataChart.Chart();
        in.close();
    }
}