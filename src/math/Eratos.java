package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 소수의 개수 구하기
public class Eratos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] check = new boolean[1001]; // 거짓이여야 소수

        check[1] = true;

        for (int i = 2; i <= 1000; i++) {
            if (!check[i]) {
                for (int j = 2; i * j <= 1000; j++) {
                    check[i * j] = true;
                }
            }
        }

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if(!check[temp]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
