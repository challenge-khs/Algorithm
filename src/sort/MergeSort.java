package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeSort {
    public static int[] arr;
    public static int[] tmp;

    public static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);

            int p = start;
            int q = mid + 1;
            int idx = p;

            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && arr[p] < arr[q])) {
                    tmp[idx++] = arr[p++];
                } else {
                    tmp[idx++] = arr[q++];
                }
            }

            for (int i = start; i <= end; i++) {
                arr[i] = tmp[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        tmp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, arr.length - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
}
