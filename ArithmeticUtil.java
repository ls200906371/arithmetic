package com.study.one.arithmetic;

import java.util.Arrays;

public class ArithmeticUtil {

    public static void main(String[] args) {
        int[] arr = {8,3,1,9,2,0,4,7,6,5};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr){
        if(arr == null || arr.length < 2){
            return ;
        }

        for(int i =0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    arr[i] = arr[j] + arr[i];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }
        }
    }

    public static void bubblingSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i -1; j++){
                if(arr[j] > arr[j+1]){
                    arr[j] = arr[j] + arr[j+1];
                    arr[j+1] = arr[j] - arr[j+1];
                    arr[j] = arr[j] - arr[j+1];
                }
            }
        }
    }

    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quickSortRecursion(arr, 0, arr.length - 1);
    }

    private static void quickSortRecursion(int[] arr, int start, int end){

        if(start < end) {
            int i = start;
            int j = end;
            int x = arr[i];

            while(i < j){
                while(i < j && arr[j] > x){
                    j--;
                }
                if(i < j) {
                    arr[i++] = arr[j];
                }
                while(i < j && arr[i] < x){
                    i++;
                }
                if(i < j){
                    arr[j--] = arr[i];
                }
            }
            arr[i] = x;
            quickSortRecursion(arr, start, i - 1);
            quickSortRecursion(arr, i + 1, end);
        }
    }

    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        mergeSortRecursion(arr, 0, arr.length - 1, new int[arr.length]);
    }

    private static void mergeSortRecursion(int[] arr, int start, int end, int[] tmp){
        if(start < end){
            int mid = (start + end) >>> 1;

            mergeSortRecursion(arr, start, mid, tmp);
            mergeSortRecursion(arr, mid + 1, end, tmp);

            int i = start;
            int j = mid + 1;
            int k = 0;
            while(i <= mid && j <= end){
                if(arr[i] < arr[j]){
                    tmp[k++] = arr[i++];
                }else{
                    tmp[k++] = arr[j++];
                }
            }

            while(i <= mid){
                tmp[k++] = arr[i++];
            }

            while(j <= end){
                tmp[k++] = arr[j++];
            }

            for(i = 0; i < k; i++){
                arr[start + i] = tmp[i];
            }
        }
    }


    public static int middleQuery(int[] arr, int target){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) >>> 1;

        while(arr[mid] != target){
            if(arr[mid] > target){
                end = mid - 1;
            }else if(arr[mid] < target){
                start = mid + 1;
            }
            if(start > end){
                return -1;
            }
            mid = (start + end) >>> 1;
        }
        return mid;
    }
}
