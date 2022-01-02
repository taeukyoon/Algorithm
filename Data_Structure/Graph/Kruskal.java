import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
Data-Structure
 Kruskal 알고리즘
 Date: 21-12-27
 */
public class Main {
    static int a, b, cost;
    static int[][] graph;
    static int[] parent;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken()); //정점의 개수
        b = Integer.parseInt(st.nextToken()); //간선의 개수
        graph = new int[b][3];


        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        parent = new int[a];
        Arrays.sort(graph, ((o1, o2) -> Integer.compare(o2[2],o1[2])));
        makeSet(parent, a);
        kruskal();
    }

    private static int[] makeSet(int[] parent, int x) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        return parent;
    }

    private static void kruskal() {
        cost = 0;

        for (int i = 0; i < b; i++) {
            if (find(graph[i][0] - 1) != find(graph[i][1] - 1)) {
                System.out.println("선택된 간선");
                System.out.println(Arrays.toString(graph[i]));
                union(graph[i][0] - 1, graph[i][1] - 1);
                cost += graph[i][2];
                System.out.println("각 노드가 가르키는 부모");
                System.out.println(Arrays.toString(parent) + "\n");
                continue;
            }
        }
    }

    private static void union(int a, int b) {
        int a1 = find(a);
        int a2 = find(b);

        if (a1 > a2) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return find(parent[x]);
        }
    }
}
