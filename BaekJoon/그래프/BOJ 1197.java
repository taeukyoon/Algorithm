import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 1197 최소 스패닝 트리
 solve: Kruskal 알고리즘
 Date: 21-12-27
 */
public class Main {
    static int v, e, cost;
    static int[][] graph;
    static int[] parent;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken()); //정점의 개수
        e = Integer.parseInt(st.nextToken()); //간선의 개수
        graph = new int[e][3];

        //간선의 정보
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(graph, ((o1, o2) -> Integer.compare(o1[2],o2[2])));
        makeSet(v);

        for (int i = 0; i < e; i++) {
            if (find(graph[i][0]) != find(graph[i][1])) { //사이클 존재 x
                union(graph[i][0], graph[i][1]);
                cost += graph[i][2];
            }
        }
        System.out.println(cost);
    }

    private static int[] makeSet(int size) {
        parent = new int[size + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        } return parent;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return find(parent[x]);
        }
    }

    private static void union(int a, int b) {
        int a1 = find(a);
        int b1 = find(b);

        if (a1 > b1) {
            parent[a1] = b1;
        } else {
            parent[b1] = a1;
        }
    }
}
