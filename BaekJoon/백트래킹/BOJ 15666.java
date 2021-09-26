import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 15666 N과 M(12)
 Date: 21-09-26
 */
public class Main {
    static int N, M;
    static int[] num;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        dfs(0,0);
        System.out.println(sb);
    }
    public static void dfs(int start, int depth) {
        if(depth == M) {
            for(int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        int cur = 0;
        for(int i = start; i < N; i++) {
            if(cur == num[i]) continue;

            arr[depth] = num[i];
            dfs(i, depth + 1);
            cur = num[i];
        }
    }
}
