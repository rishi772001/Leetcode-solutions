package com.rishi.Easy;

import java.util.Arrays;

public class Sort {
    public static void swap(int[][] arr, int j, int k, int n){
        for(int i = k; i < n; i++){
            int temp = arr[j][i];
            arr[j][i] = arr[j + 1][i];
            arr[j + 1][i] = temp;
        }
        for(int[] i : arr){
            System.out.println(Arrays.toString(i));
        }
        System.out.println();
    }

    public static void sort(int[][] arr, int k, int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - 1; j++){
                if(arr[j][k] > arr[j + 1][k]){
                    swap(arr, j, k, n);
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = {
                {9,2,3,4,5},
                {2,0,1,1,8},
                {7,5,4,3,2},
                {2,9,8,6,0},
                {1,2,3,4,5}
        };

        int n = 5;
        int to_sort = 3;
        for(int j = 0; j < to_sort; j++){
            System.out.println("Sorting "+ (j + 1) +"st column");
            sort(arr, j, n);

            for(int[] i : arr){
                System.out.println(Arrays.toString(i));
            }
            System.out.println();
        }
    }
}
