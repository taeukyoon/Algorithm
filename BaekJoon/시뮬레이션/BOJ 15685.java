import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 BOJ 15685 드래곤 커브
 Date: 21-10-28
 */
public class Main{
    static int N, x, y, d, g;
    static boolean[][] map = new boolean[101][101];

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            draw(x, y, direction(d, g));
        }
        System.out.println(square());
    }
    public static List<Integer> direction(int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);

        while(g-- > 0) {
            for(int i = directions.size() - 1; i >= 0; i--) {
                int dir = (directions.get(i) + 1) % 4;
                directions.add(dir);
            }
        }
        return directions;
    }
    public static void draw(int x, int y, List<Integer> direction) {
        map[x][y] = true;

        for(int dir : direction) {
            switch (dir) {
                case 0:
                    map[++x][y] = true;
                    break;
                case 1:
                    map[x][--y] = true;
                    break;
                case 2:
                    map[--x][y] = true;
                    break;
                case 3:
                    map[x][++y] = true;
                    break;
            }
        }
    }
    public static int square() {
        int cnt = 0;

        for (int i = 0; i < map.length - 1; i++) {
            for(int j = 0; j < map.length - 1; j++) {
                if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}