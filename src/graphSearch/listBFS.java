package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class listBFS {
    public static int n, m, v;
    public static boolean[] visited;
    public static ArrayList<Integer>[] adj;
    public static StringBuilder sb;

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);
        while (!q.isEmpty()) {
            int x = q.poll();
            sb.append(x + " ");
            int len = adj[x].size();
            for (int i = 0; i < len; i++) {
                int next = adj[x].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
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

        visited = new boolean[n + 1];
        adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            String str2 = br.readLine();
            StringTokenizer st2 = new StringTokenizer(str2, " ");
            int s = Integer.parseInt(st2.nextToken());
            int e = Integer.parseInt(st2.nextToken());
            adj[s].add(e);
            adj[e].add(s);
        }

        bfs(v);
        System.out.println(sb);
    }
}
