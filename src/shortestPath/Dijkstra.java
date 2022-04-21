package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//1753
class Node implements Comparable<Node> {
    int to, weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) { // 가중치가 적은 순으로
        return this.weight - o.weight;
    }
}

public class Dijkstra {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        PriorityQueue<Node>[] adj = new PriorityQueue[V + 1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new PriorityQueue<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }

        int[] distance = new int[V + 1];
        Arrays.fill(distance, -1);
        distance[start] = 0;

        while (!adj[start].isEmpty()) {
            Node temp = adj[start].poll();
            int to = temp.to;
            int weight = temp.weight;

            if(distance[to] != -1)
                continue;
            distance[to] = weight;
            for (Node n : adj[to]) {
                adj[start].add(new Node(n.to, n.weight + weight));
            }
        }
        for (int i = 1; i <= V; i++) {
            sb.append(distance[i] == -1 ? "INF" : distance[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
