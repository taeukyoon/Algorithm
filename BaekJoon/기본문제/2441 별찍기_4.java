import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 백준 2441 별찍기-4
 */
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            //빈공백
            for(int k = 0; k < i; k++){
                sb.append(" ");
            }
            //별찍기
            for(int j = N; j > i; j--) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
