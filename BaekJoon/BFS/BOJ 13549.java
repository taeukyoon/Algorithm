
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 13549 숨바꼭질3
 출력: 수빈이가 동생을 찾는 가장 빠른시간을 구한다 (bfs)
 수빈이의 위치 N, 동생위치 K 두개 다 정수이다.
 이동거리는 x+1, x-1, 순간이동에는 2*x
 */
public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int N, K;
    static Queue<Point> qu;
    static boolean[] visited = new boolean[100001];
    static int arr[] = new int[100001];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(N == K) {
            System.out.println(0);
        }else {
            bfs(N);
        }
    }
    public static void bfs(int n) {
        qu = new LinkedList<>();
        qu.offer(new Point(n, 0));

        while(!qu.isEmpty()) {
            Point p = qu.poll();
            visited[p.x] = true;

            if(p.x == K) {
                min = Math.min(min, p.y);
            }
            if(p.x * 2 <= 100000 && !visited[p.x * 2]) {
                qu.add(new Point(p.x * 2, p.y));
            }
            if(p.x + 1 <= 100000 && !visited[p.x + 1]) {
                qu.add(new Point(p.x + 1, p.y + 1));
            }
            if(p.x - 1 >= 0 && !visited[p.x -1]) {
                qu.add(new Point(p.x - 1, p.y + 1));
            }
        }
        System.out.println(min);
    }
}