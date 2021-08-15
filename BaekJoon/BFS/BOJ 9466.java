import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int t, n;
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int cnt = 0;


/*
 BOJ 9466 텀프로젝트
 dfs 사용하지만 그냥 처음부터 탐색하면 시간복잡도가 초과하는 문제
 */
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            cnt = 0;

            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n + 1; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 1; j < n + 1; j ++) {
                dfs(j);
            }
            System.out.println(n - cnt);
        }
    }
    static void dfs(int x) {
        if(visited[x]) {
            return;
        }
        visited[x] = true;
        int n = arr[x];

        if(visited[n] != true) {
            dfs(n);
        }
        else {
            if(finished[n] != true) {
                cnt++;
                for(int i = n; i != x; i = arr[i]) {
                    cnt++;
                }
            }
        }
        finished[x] = true;
    }
}