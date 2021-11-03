import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 BOJ 16234 인구 이동
 Date: 21-11-3
 solve: bfs
 */
public class Main{
    static int N, L, R, flag;
    static int[][] map, openMap;
    static boolean[][] visited;
    static int cnt = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        loop:while (true) {
            visited = new boolean[N][N];
            openMap = new int[N][N];
            flag = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    check(new Node(i, j));
                }
            }
            if(flag == 0) {
                break loop;
            } else {
                cnt++;
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(openMap[i][j] == 1 && !visited[i][j]) {
                        bfs(new Node(i, j));
                    }
                }
            }
        }
        System.out.println(cnt);
    }
    public static void bfs(Node n) {
        Queue<Node> qu = new LinkedList<>();
        ArrayList<Node> save = new ArrayList<>();
        qu.add(n);
        visited[n.x][n.y] = true;
        int sum = 0;
        int count = 0;

        while (!qu.isEmpty()) {
            Node c = qu.poll();
            int x = c.x;
            int y = c.y;
            save.add(c);
            sum += map[x][y]; //빠지는것들 총합
            count++;

            for(int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx >= 0 && ny >=0 && nx < N && ny < N) {
                    if(!visited[nx][ny] && Math.abs(map[x][y] - map[nx][ny]) >= L && Math.abs(map[x][y] - map[nx][ny]) <= R) {
                        qu.add(new Node(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        int divide = sum / count;

        for(int i = 0; i < save.size(); i++) {
            Node c = save.get(i);
            map[c.x][c.y] = divide;
        }
    }
    public static void check(Node n) {
        int x = n.x;
        int y = n.y;

        for(int k = 0; k < 4; k++) { //상하좌우 체크
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if(Math.abs(map[x][y] - map[nx][ny]) >= L && Math.abs(map[x][y] - map[nx][ny]) <= R) {
                    openMap[x][y] = 1;
                    openMap[nx][ny] = 1;
                    flag++;
                }
            }
        }
    }
}
class Node {

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x, y;
}