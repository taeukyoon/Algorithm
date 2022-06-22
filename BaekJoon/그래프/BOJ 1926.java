import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 1926 그림
 BFS 이용하여 풀기 (한번더 풀어보자)
 */
class Main{

    static Queue<Node> queue;
    static int dx[] = {1, 0, -1, 0}; //오른쪽, 아래, 왼쪽, 위 순서
    static int dy[] = {0, 1, 0, -1};
    static int drawCnt = 0;
    static int maxDrawSize = 0;
    static boolean[][] visited;
    static int[][] map;
    static int n;
    static int m;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        //그림만들기
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //방문하지 않았거나, 색칠이된 부분
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(drawCnt);
        System.out.println(maxDrawSize);
    }
    public static void bfs(int x, int y) {
        queue = new LinkedList<>();
        queue.add(new Node(x, y));
        int cnt = 0;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            cnt++;
            for(int k = 0; k < 4; k++) {
                int nx = node.x + dx[k];
                int ny = node.y + dy[k];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(visited[nx][ny] || map[nx][ny] == 0) continue;
                visited[nx][ny] = true;
                queue.add(new Node(nx,ny));
            }
        }
        drawCnt++;
        if(cnt > 1) {
            cnt--;
        }
        maxDrawSize = Math.max(maxDrawSize, cnt);
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}