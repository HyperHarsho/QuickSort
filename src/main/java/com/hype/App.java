package com.hype;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class App {
    public static int loop = 0;
    public static Map<Integer, Integer> data = new HashMap<>();
    public static Map<Integer, Integer> data1 = new HashMap<>();
    public static Map<Integer, Integer> data2 = new HashMap<>();
    public static Map<Integer, Integer> data3 = new HashMap<>();
    public static Map<Integer, Integer> data4 = new HashMap<>();
    public static Map<Integer, Integer> data5 = new HashMap<>();
    public static Map<Integer, Integer> data6 = new HashMap<>();
    public static Map<Integer, Integer> data7 = new HashMap<>();
    public static Map<Integer, Integer> data8 = new HashMap<>();
    public static Map<Integer, Integer> data9 = new HashMap<>();
    public static Map<Integer, Integer> data10 = new HashMap<>();

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

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

    public static void quickSort(int arr[], int high, int low) {
        if (low < high) {
            loop++;
            int p = partition(arr, high, low);

            quickSort(arr, p - 1, low);
            quickSort(arr, high, p + 1);
        }
    }

    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static int[] randomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            Random rand = new Random();
            arr[i] = rand.nextInt(999999999);
        }
        return arr;
    }

    public static void base(int size) {
        for (int i = 1; i <= size; i++) {
            loop = 0;
            int arr[] = randomArray(i + 1);
            quickSort(arr, i, 0);
            data1.put(i, loop);
        }
        for (int i = 1; i <= size; i++) {
            loop = 0;
            int arr[] = randomArray(i + 1);
            quickSort(arr, i, 0);
            data2.put(i, loop);
        }
        for (int i = 1; i <= size; i++) {
            loop = 0;
            int arr[] = randomArray(i + 1);
            quickSort(arr, i, 0);
            data3.put(i, loop);
        }
        for (int i = 1; i <= size; i++) {
            loop = 0;
            int arr[] = randomArray(i + 1);
            quickSort(arr, i, 0);
            data4.put(i, loop);
        }
        for (int i = 1; i <= size; i++) {
            loop = 0;
            int arr[] = randomArray(i + 1);
            quickSort(arr, i, 0);
            data5.put(i, loop);
        }
        for (int i = 1; i <= size; i++) {
            loop = 0;
            int arr[] = randomArray(i + 1);
            quickSort(arr, i, 0);
            data6.put(i, loop);
        }
        for (int i = 1; i <= size; i++) {
            loop = 0;
            int arr[] = randomArray(i + 1);
            quickSort(arr, i, 0);
            data7.put(i, loop);
        }
        for (int i = 1; i <= size; i++) {
            loop = 0;
            int arr[] = randomArray(i + 1);
            quickSort(arr, i, 0);
            data8.put(i, loop);
        }
        for (int i = 1; i <= size; i++) {
            loop = 0;
            int arr[] = randomArray(i + 1);
            quickSort(arr, i, 0);
            data9.put(i, loop);
        }
        for (int i = 1; i <= size; i++) {
            loop = 0;
            int arr[] = randomArray(i + 1);
            quickSort(arr, i, 0);
            data10.put(i, loop);
        }
        for (int i = 1; i <= size; i++) {
            int avg = 0;
            avg += data1.get(i);
            avg += data2.get(i);
            avg += data3.get(i);
            avg += data4.get(i);
            avg += data5.get(i);
            avg += data6.get(i);
            avg += data7.get(i);
            avg += data8.get(i);
            avg += data9.get(i);
            avg += data10.get(i);
            avg = (int) avg / 10;
            data.put(i, avg);
        }
        System.out.println("Length \t Loops");
        for (Map.Entry<Integer, Integer> m : data.entrySet()) {
            System.out.println(m.getKey() + " \t " + m.getValue());
        }
    }

    public static void main(String[] args) {
        base(50);
        DataChart.Chart();
    }
}