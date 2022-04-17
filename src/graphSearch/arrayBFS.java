package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class arrayBFS {
    public static int n, m, v;
    public static int[][] map;
    public static boolean[] visited;
    public static StringBuilder sb;

    public static void arrayBfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int temp = q.poll();
            sb.append(temp + " ");
            for (int i = 1; i <= n; i++) {
                if (map[temp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
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

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            String str2 = br.readLine();
            StringTokenizer st2 = new StringTokenizer(str2, " ");
            int s = Integer.parseInt(st2.nextToken());
            int e = Integer.parseInt(st2.nextToken());
            map[s][e] = 1;
            map[e][s] = 1;
        }

        arrayBfs(v);
        System.out.println(sb);
    }
}
