package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//1260
public class listDFS {
    public static int n, m, v;
    public static boolean[] visited;
    public static ArrayList<Integer>[] adj;
    public static StringBuilder sb;

    public static void listDfs(int start) {
        visited[start] = true;
        sb.append(start+ " ");
        int len = adj[start].size();
        for (int i = 0; i < len; i++) {
            int next = adj[start].get(i);
            if (!visited[next]) {
                listDfs(next);
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

        listDfs(v);
        System.out.println(sb);
    }
}
