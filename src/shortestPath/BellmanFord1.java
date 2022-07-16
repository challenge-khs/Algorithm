package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 음수 가중치가 있는 그래프에서 특정 시작점에서 다른 나머지 정점까지의 최단거리를 구함
//11657
class City {
    int end;
    int weight;

    City(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}
public class BellmanFord1 {
    static int N, M;
    static ArrayList<ArrayList<City>> arr;
    static long[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static boolean bellmanFord() {
        dist[1] = 0;
        boolean update = false;

        for (int i = 1; i < N; i++) {
            update = false;
            for (int j = 1; j <= N; j++) {
                for (City c : arr.get(j)) {
                    if (dist[j] == INF) {
                        break;
                    }

                    if(dist[c.end] > dist[j] + c.weight) {
                        dist[c.end] = dist[j] + c.weight;
                        update = true;
                    }
                }
            }
            if (!update) {
                break;
            }
        }

        if (update) {
            for (int i = 1; i <= N; i++) {
                for (City c : arr.get(i)) {
                    if (dist[i] == INF) {
                        break;
                    }

                    if (dist[c.end] > dist[i] + c.weight) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        dist = new long[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arr.add(new ArrayList<>());
            dist[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.get(a).add(new City(b, c));
        }

        if (bellmanFord()) {
            System.out.println("-1");
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    System.out.println("-1");
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }
}
