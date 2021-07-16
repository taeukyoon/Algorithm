import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 2446 별찍기-9
 */
public class Main {
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int m = 2*N;

        for(int i = 1; i < m; i++) {
            if(i <= N) {
                sb.append(" ".repeat(i-1));
                sb.append("*".repeat(2*(N-i)+1));
                sb.append("\n");
            }else {
                sb.append(" ".repeat(m-i-1));
                sb.append("*".repeat(2*(i-N)+1));
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
