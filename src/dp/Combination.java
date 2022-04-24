package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Combination {
    static int[][] dp;

    static int comb(int n, int r) {
        if(dp[n][r] > 0)
            return dp[n][r];
        if(r == 0 || n == r)
            return dp[n][r] = 1;

        return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        dp = new int[10001][10001];
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(comb(n, m)).append('\n');
        }

        System.out.print(sb.toString());
    }
}
