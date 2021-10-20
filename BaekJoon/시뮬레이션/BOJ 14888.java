import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 14888 연산자 끼워넣기
 Date: 21-10-20
 */
public class Main{
    static int N;
    static int[] num;
    static int[] operator = new int[4];
    static int Max = Integer.MIN_VALUE;
    static int Min = Integer.MAX_VALUE;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(num[0], 1);

        System.out.println(Max);
        System.out.println(Min);
    }
    public static void dfs(int firstNum, int idx) {
        if(idx == N) {
            Max = Math.max(Max, firstNum);
            Min = Math.min(Min, firstNum);
            return;
        }

        for(int k = 0; k < 4; k++) {
            if(operator[k] > 0) {
                operator[k]--;

                switch(k) {
                    case 0: dfs(firstNum + num[idx], idx + 1); break;
                    case 1: dfs(firstNum - num[idx], idx + 1); break;
                    case 2: dfs(firstNum * num[idx], idx + 1); break;
                    case 3: dfs(firstNum / num[idx], idx + 1); break;
                }
                operator[k]++;
            }
        }
    }
}