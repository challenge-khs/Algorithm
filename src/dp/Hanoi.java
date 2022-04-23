package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//11729
public class Hanoi {
    public static StringBuilder sb = new StringBuilder();

    public static void hanoi(int n, int start, int mid, int to) {
        if (n == 1) { // 원판이 1개일 때
            sb.append(start + " " + to + "\n");
            return;
        }

        // A -> C로 옮김
        // A의 원판 n-1개를 B로 이동
        hanoi(n - 1, start, to, mid);
        // A의 원판 1개를 C로 이동
        sb.append(start + " " + to + "\n");
        // B의 원판 n-1개를 C로 이동
        hanoi(n - 1, mid, start, to);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        sb.append((int) (Math.pow(2, n) - 1) + "\n");

        hanoi(n, 1, 2, 3);
        System.out.print(sb);
    }
}
