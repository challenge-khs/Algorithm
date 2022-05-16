package binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    static int search(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if(arr[mid] == target)
                return mid;
            else if(target < arr[mid])
                end = mid - 1;
            else
                start = mid +1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = search(arr, target, 0, arr.length);
        System.out.println(answer);
    }
}
