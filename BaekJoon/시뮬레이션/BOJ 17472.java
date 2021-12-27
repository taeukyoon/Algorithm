import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 17472 다리만들기 2
 solved: Kruskal Algorithm, bfs
 Date: 21-12-27
 feedBack: pq 사이즈를 반복문에 두었다가 값이 실시간으로 바뀌는걸 고려하지않아서 오류가 났다
 */
public class Main {
    static int n, m, island, res, cnt = 0;
    static int[][] map;
    static int[] parent;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        //bfs 좌표
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    island++;
                    bfs(new Node(i, j));
                }
            }
        }

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    makeBridge(new Node(i, j),map[i][j]);
                }
            }
        }

        parent = new int[island + 1];
        //makeSet
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        //union-find
        int size = pq.size();
        for (int i = 0; i < size; i++) {
            Edge val = pq.poll();

            int a = find(val.s);
            int b = find(val.e);
            if (a == b) continue;
            union(val.s, val.e);
            res += val.v;
            cnt++;
        }

        if (res == 0 || cnt != island - 1) {
            System.out.println(-1);
        } else System.out.println(res);
    }

    public static int find(int i) {
        if (parent[i] == i) {
            return i;
        } else {
            return find(parent[i]);
        }
    }

    public static void union(int a, int b) {
        int a1 = find(a);
        int b1 = find(b);

        if (a1 != b1) {
            parent[a1] = b1;
        } else {
            parent[b1] = a1;
        }
    }

    // 섬에서 상하좌우로 다른섬이 나올때 까지 계속 이동한다
    public static void makeBridge(Node p, int num) {
        int x = p.x;
        int y = p.y;
        int length = 0;

        for (int k = 0; k < 4; k++) {
            while (true) {
                x = x + dx[k];
                y = y + dy[k];

                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (map[x][y] == num) {
                        length = 0;
                        x = p.x;
                        y = p.y;
                        break;
                    } else if (map[x][y] == 0) {
                        length++;
                    } else {
                        if (length > 1) {
                            pq.add(new Edge(num, map[x][y], length));
                        }
                        length = 0;
                        x = p.x;
                        y = p.y;
                        break;
                    }
                } else {
                    length = 0;
                    x = p.x;
                    y = p.y;
                    break;
                }
            }
        }
    }

    //각 섬의 번호 지정해주기
    public static void bfs(Node p) {
        Queue<Node> qu = new LinkedList<>();
        visited[p.x][p.y] = true;
        map[p.x][p.y] = island;
        qu.add(p);

        while (!qu.isEmpty()) {
            Node now = qu.poll();
            int x = now.x;
            int y = now.y;

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    qu.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = island;
                }
            }
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //간선
    static class Edge implements Comparable<Edge> {
        int s, e, v;

        public Edge(int s, int e, int v) {
            super();
            this.s = s;
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return (o.v >= this.v) ? -1 : 1;
        }
    }
}
