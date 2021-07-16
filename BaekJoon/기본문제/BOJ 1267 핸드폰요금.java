import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 BOJ 1267 핸드폰 요금
 */
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int y = 0;
        int m = 0;
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            y += ((arr[i]/30)+1) * 10;
            m += ((arr[i] / 60) +1) * 15;
        }
        if(y == m) {
            System.out.println("Y M"+" "+ y);
        }
        else if(y < m) {
            System.out.println("Y"+" "+ y);
        }else {
            System.out.println("M"+" "+ m);
        }
    }
}
