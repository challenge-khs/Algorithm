package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 음수 가중치가 있는 그래프에서 특정 시작점에서 다른 나머지 정점까지의 최단거리를 구함
// 11657
public class BellmanFord2 {
    static int n, m;
    static Info[] infos;
    static Long[] dist;
    static final Long INF = Long.MAX_VALUE;

    static class Info {
        int s, e ,cost;

        public Info(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }

    public static boolean bellmanFord() {
        dist[1] = 0L;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                Info info = infos[j];

                if(dist[info.s] != INF && dist[info.e] > dist[info.s] + info.cost)
                    dist[info.e] = dist[info.s] + info.cost;
            }
        }
        for (int i = 0; i < m; i++) {
            Info info = infos[i];

            if(dist[info.s] != INF && dist[info.e] > dist[info.s] + info.cost)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        infos = new Info[m];
        dist = new Long[n + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            infos[i] = new Info(a, b, c);
        }

        if (!bellmanFord()) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= n; i++) {
                System.out.println(dist[i].equals(INF) ? -1 : dist[i]);
            }
        }
    }
}
