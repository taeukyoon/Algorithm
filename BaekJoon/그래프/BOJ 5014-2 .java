import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 5014 스타트링크 
 */
public class Main {
    static int F, S, G, U, D;
    static boolean[] visited;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];
        visited[S] = true;
        boolean flag = true;
        int count = 0;

        while(S != G) {
            count++;
            if(S < G) {
                if(S + U <= F && !visited[S + U]) {
                    visited[S + U] = true;
                    S += U;
                } else if(S - D >= 1 && !visited[S - D]) {
                    visited[S - D] = true;
                    S -= D;
                } else {
                    flag = false;
                    break;
                }
            } else if(S > G) {
                if(S - D > 0 && !visited[S -D]) {
                    visited[S - D] = true;
                    S -= D;
                } else if(S + U <= F && !visited[S + U]) {
                    visited[S + U] =true;
                    S += U;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        if(flag) {
            System.out.println(count);
        }else {
            System.out.println("use the stairs");
        }
        br.close();
    }
}
