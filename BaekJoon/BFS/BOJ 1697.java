import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 BOJ 1697 숨바꼭질
 BFS 이용 최단거리
 */
class Main{
    static int n, k;
    static int[] visited = new int[100001];
    static Queue<Integer> qu;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n == k) {
            System.out.println(0);
        }else bfs(n);
    }

    static void bfs(int N) {
        qu = new LinkedList<>();
        qu.add(N);
        visited[N] = 1;

        while (!qu.isEmpty()) {
            int temp = qu.poll();

            for(int i = 0; i < 3; i++) {
                int nx;

                if(i == 0) {
                    nx = temp + 1;
                }
                else if(i == 1) {
                    nx = temp - 1;
                } else {
                    nx = temp * 2;
                }
                if(nx == k) {
                    System.out.println(visited[temp]);
                    return;
                }

                if(nx >= 0 && nx < visited.length && visited[nx] == 0) {
                    qu.add(nx);
                    visited[nx] = visited[temp] + 1;
                }
            }
        }
    }
}