import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 BOJ 11559 Puyo Puyo
 Date: 21-10-8
 주어진 상황에서 몇 연쇄까지 가능한지 출력
 1. 같은색 뿌요가 4개이상 상화좌우로 연결되어 있으면 1연쇄
 2. 연쇄후 뿌요가 사라지면 위에 있는 뿌요가 중력영향 받아서 아래로 내려온다
 3. 터질 수 있는 뿌요가 여러 그룹이 있으면 동시에 터진다.
 */
public class Main{
    static final int row = 12, col = 6;
    static int cnt, res = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[row][col];

        for(int i = 0; i < row; i++) {
            char[] str = br.readLine().toCharArray();
            for(int j = 0; j < col; j++) {
                map[i][j] = str[j];
            }
        }
        //연쇄
        while (true) {
            visited = new boolean[row][col];
            boolean flag = false; // 연산했는지 안했는지
            //4개 같은거 찾기
            for(int i = 0; i < row; i++) {
                for(int j = 0; j < col; j++) {
                    if(!visited[i][j] && map[i][j] != '.') { //방문하지 않고 .이 아닌곳
                        cnt = 1;
                        if(search(i, j, map[i][j])) {
                            flag = true;
                            bfs(i,j,map[i][j]);
                        }
                    }
                }
            }
            if(flag) { //연쇄작용
                res++;
            } else {
                break;
            }

            while (true) {
                boolean check = false;
                check = gravity(check);

                if(!check) {
                    break;
                }
            }
        }
        System.out.println(res);
    }
    public static boolean gravity(boolean check) {
        for(int i = 11; i > 0; i--) {
            for(int j = 5; j > 0; j--) {
                if(map[i][j] == '.' && map[i-1][j] != '.') {
                    check = true;
                    map[i][j] = map[i-1][j];
                    map[i-1][j] = '.';
                }
            }
        }
        return check;
    }
    public static void bfs(int x, int y, char color) {
        Queue<Puyo> qu = new LinkedList();
        qu.add(new Puyo(x, y));

        while (!qu.isEmpty()) {
            Puyo p = qu.poll();

            for(int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if(nx < 0 || ny < 0 || nx >= row || ny >= col || map[nx][ny] != color) continue;
                if(visited[nx][ny] && map[nx][ny] == color) {
                    map[nx][ny] = '.';
                    qu.add(new Puyo(nx, ny));
                }
            }
        }
    }
    public static boolean search(int x, int y, char color) {
        visited[x][y] = true;

        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx < 0 || ny < 0 || nx >= row || ny >= col || map[nx][ny] != color) continue;
            if(!visited[nx][ny] && map[nx][ny] == color) {
                cnt++;
                search(nx, ny, color);
            }
        }
        if(cnt == 4) {
            return  true;
        }
        return false;
    }
    static class Puyo {
        public Puyo(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x, y;
    }
}