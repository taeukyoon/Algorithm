import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 백준 2442 별찍기-5
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {

            //공백
            for(int j = i; j < N; j++) {
                System.out.print(" ");
            }

            //별찍기
            for(int k = 0; k < i*2-1; k++) {
                System.out.print("*");
            }
            //줄바꿈
            System.out.println();
        }
        br.close();
    }
}
