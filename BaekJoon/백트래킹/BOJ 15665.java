import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 15665 N과 M(11)
 Date: 21-09-24
 */
public class Main{
    static int N, M;
    static int[] arr;
    static int[] num;
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
        dfs(0);
        System.out.println(sb);
    }
    public static void dfs(int depth) {

        if(depth == M) {
            for(int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append('\n');
            return;
        }
        int cur = 0;
        for(int i = 0; i < N; i++) {
            if(cur == num[i]) continue;
            arr[depth] = num[i];
            dfs(depth + 1);
            cur = num[i];
        }
    }
}