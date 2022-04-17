package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class arrayDFS {
    public static int n, m, v;
    public static boolean[] visited;
    public static int[][] map;
    public static StringBuilder sb;

    public static void arrayDfs(int start) {
        visited[start] = true;
        sb.append(start + " ");
        for (int i = 1; i <= n; i++) {
            if(map[start][i] == 1 && !visited[i])
                arrayDfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String str1 = br.readLine();
        StringTokenizer st1 = new StringTokenizer(str1, " ");
        n = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        v = Integer.parseInt(st1.nextToken());

        visited = new boolean[n + 1];
        map = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            String str2 = br.readLine();
            StringTokenizer st2 = new StringTokenizer(str2, " ");
            int s = Integer.parseInt(st2.nextToken());
            int e = Integer.parseInt(st2.nextToken());
            map[s][e] = 1;
            map[e][s] = 1;
        }

        arrayDfs(v);
        System.out.println(sb);
    }
}
