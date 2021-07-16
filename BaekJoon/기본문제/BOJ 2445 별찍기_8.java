import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 BOJ 2445 별찍기-8
 */
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int m = 2 * N;

        for(int i = 1; i < m; i++) {
            if(i <= N) {
                sb.append("*".repeat(i));
                sb.append(" ".repeat(2*(N-i)));
                sb.append("*".repeat(i)).append("\n");
            }else{
                sb.append("*".repeat(m-i));
                sb.append(" ".repeat(2*(i-N)));
                sb.append("*".repeat(m-i)).append("\n");
            }
        }
        System.out.print(sb);
    }
}

