import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 1579 암호 만들기
 Date: 21-09-29
 */
public class Main {
    static int L, C;
    static char[] res, arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        res = new char[L];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        dfs(0, 0, 0, 0);
        System.out.println(sb);
    }
    public static void dfs(int start, int depth, int v, int c) {
        if(depth == L) {
            if(v >= 1 && c >= 2) {
                for(char val : res) {
                    sb.append(val);
                }
                sb.append("\n");
            }
            return;
        }
        for(int i = start; i < C; i++) {
            res[depth] = arr[i];

            if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                dfs(i + 1, depth + 1, v + 1, c);
            } else {
                dfs(i + 1, depth + 1, v, c + 1);
            }
        }
    }
}