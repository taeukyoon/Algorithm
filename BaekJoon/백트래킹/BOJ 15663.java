import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 15663 N과 M(9)
 Date: 21-09-18
 */
public class Main{
    static int N, M;
    static int[] arr;
    static int[] num;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        num = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        dfs(0);
        System.out.println(sb);
    }
    public static void dfs(int depth) {
        if(depth == M) {
            for(int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                int cnt = 0;
                for(int j = 0; j < list.size(); j++) {
                    if (num[i] == list.get(j)) {
                        cnt++;
                    }
                }
                if(cnt == 0) {
                    visited[i] = true;
                    arr[depth] = num[i];
                    list.add(num[i]);
                    dfs(depth + 1);
                    visited[i] = false;
                }else {
                    continue;
                }
            }
        }
    }
}