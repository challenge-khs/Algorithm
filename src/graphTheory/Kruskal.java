package graphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class edge implements Comparable<edge> {
    int s, e, v;

    public edge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    @Override
    public int compareTo(edge o) {
        return o.v >= this.v ? -1 : 1;
    }
}

public class Kruskal {
    public static int n, m;
    public static int[] parent;
    public static PriorityQueue<edge> pq = new PriorityQueue<edge>();

    public static int find(int a) {
        if(a == parent[a])
            return a;
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        int result = 0;

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pq.add(new edge(s, e, v));
        }

        //for (int i = 0; i < m; i++) {
        while(!pq.isEmpty()) {
            edge temp = pq.poll();
            int a = find(temp.s);
            int b = find(temp.e);

            if (a == b)
                continue;
            union(a, b);
            result += temp.v;
        }
        System.out.println(result);
    }
}
