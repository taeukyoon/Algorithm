import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 13460 구슬 2
 Date: 21-10-18 (다시 풀어보기)
 */
public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Ball {
        int[] Red;
        int[] Blue;
        int move;

        public Ball() {
            this.move = 0;
        }

        public Ball(Ball now) {
            this.Red = now.Red.clone();
            this.Blue = now.Blue.clone();
            this.move = now.move;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        Ball b = new Ball();

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'R') {
                    b.Red = new int[] {i, j};
                    map[i][j] = '.';
                } else if(map[i][j] == 'B') {
                    b.Blue = new int[] {i, j};
                    map[i][j] = '.';
                }
            }
        }
        visited = new boolean[N][M][N][M];
        Queue<Ball> q = new LinkedList<>();
        q.add(b);
        visited[b.Red[0]][b.Red[1]][b.Blue[0]][b.Blue[1]] = true;

        while(!q.isEmpty()) {
            Ball now = q.poll();

            if(map[now.Blue[0]][now.Blue[1]] == 'O') {
                continue;
            } else if(now.move == 11) {
                continue;
            }

            if(map[now.Red[0]][now.Red[1]] == 'O') {
                System.out.println(now.move);
                System.exit(0);
            }

            for(int k = 0; k < 4; k++) {
                Ball next = move(k, now);
                if(visited[next.Red[0]][next.Red[1]][next.Blue[0]][next.Blue[1]]) continue;

                visited[next.Red[0]][next.Red[1]][next.Blue[0]][next.Blue[1]] = true;
                q.offer(next);
            }
        }
        System.out.println("-1");
    }
    public static Ball move(int dir, Ball now) {
        Ball next = new Ball(now);
        int nr = 0, nc = 0, flag = 0;
        switch(dir) {
            case 0: //위
                if(next.Red[0] > next.Blue[0]) { //파란색공이 위에 있을때 위에 있는 파란공 먼저 움직인다.
                    flag = 0;
                } else flag = 1;
            case 1: //아래
                if(next.Red[0] > next.Blue[0]) {
                    flag = 1;
                } else flag = 0;
            case 2: //왼
                if(next.Red[1] > next.Blue[1]) {
                    flag = 0;
                } else flag = 1;
            case 3: //오른쪽
                if(next.Red[1] > next.Blue[1]) {
                    flag = 1;
                } else flag = 0;

                break;
        }

        if(flag == 0) {
            nr = next.Blue[0] + dx[dir];
            nc = next.Blue[1] + dy[dir];
            while (map[nr][nc] == '.') {
                nr += dx[dir];
                nc += dy[dir];
            }

            if(map[nr][nc] == 'O') {
                next.Blue = new int[] {nr, nc};
            } else {
                next.Blue = new int[] {nr - dx[dir], nc - dy[dir]};
            }

            //빨간공
            nr = next.Red[0] + dx[dir];
            nc = next.Red[1] + dy[dir];
            while(map[nr][nc] == '.') {
                if(nr == next.Blue[0] && nc == next.Blue[1]) break;
                nr += dx[dir];
                nc += dy[dir];
            }

            if(map[nr][nc] == 'O') {
                next.Red = new int[] {nr, nc};
            } else {
                next.Red = new int[] {nr - dx[dir], nc - dy[dir]};
            }
        } else if(flag == 1){
            nr = next.Red[0] + dx[dir];
            nc = next.Red[1] + dy[dir];
            while(map[nr][nc] == '.') {
                nr += dx[dir];
                nc += dy[dir];
            }

            if(map[nr][nc] == 'O') {
                next.Red = new int[] {nr, nc};
            } else {
                next.Red = new int[] {nr - dx[dir], nc - dy[dir]};
            }

            nr = next.Blue[0] + dx[dir];
            nc = next.Blue[1] + dy[dir];
            while (map[nr][nc] == '.') {
                if(nr == next.Red[0] && nc == next.Red[1]) break;
                nr += dx[dir];
                nc += dy[dir];
            }

            if(map[nr][nc] == 'O') {
                next.Blue = new int[] {nr, nc};
            } else {
                next.Blue = new int[] {nr - dx[dir], nc - dy[dir]};
            }
        }
        next.move++;
        return next;
    }
}