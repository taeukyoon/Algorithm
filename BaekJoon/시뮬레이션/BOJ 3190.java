import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
 BOJ 3190 뱀
 Date: 21-10-17
 */
public class Main{
    static int N, K, L;
    static int[][] map;
    static int[] time, dir;
    static Deque<Node> snake = new ArrayDeque<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1; // 사과의 위치에는 1 넣어준다.
        }

        L = Integer.parseInt(br.readLine());
        time = new int[L];
        dir = new int[L];

        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            dir[i] = Direction(st.nextToken());
        }
        solve();
    }
    public static void solve() {
        int snakeDir = 1; //처음 뱀의 방향 오른쪽
        int timeIdx = 0;
        int res = 0;
        map[1][1] = 2; //처음 뱀의 위치
        snake.add(new Node(1, 1));

        while (true) {
            if(timeIdx < L && time[timeIdx] == res) { //시간 지나면 방향 바꾸기
                snakeDir = (snakeDir + dir[timeIdx]) % 4;
                timeIdx++;
            }

            int nx = snake.getFirst().x + dx[snakeDir];
            int ny = snake.getFirst().y + dy[snakeDir];

            if(nx <= 0 || ny <= 0 || nx > N || ny > N) {
                System.out.println(res + 1);//범위 넘으면
                break;
            }

            if(map[nx][ny] == 2) { //자기몸에 부딪히면
                System.out.println(res + 1);
                break;
            }

            if(map[nx][ny] == 1) {
                map[nx][ny] = 2;
                snake.addFirst(new Node(nx, ny));
            }
            else if(map[nx][ny] == 0) {
                map[nx][ny] = 2;
                snake.addFirst(new Node(nx, ny));

                Node tail = snake.removeLast();
                map[tail.x][tail.y] = 0;
            }
            res++;
        }
    }

    static class Node {
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x, y;
    }
    public static int Direction(String s) {
        if(s.equals("L")) {
            return 3;
        } else {
            return 1;
        }
    }
}