import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 백준 2577 숫자의 개수
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int val =  Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine());
        int[] arr = new int[10]; // 0~9
        String str = String.valueOf(val); //형변환

        for(int i = 0; i < str.length(); i++) {
            arr[(str.charAt(i) - 48)]++;
        }
        for(int c : arr) {
            System.out.println(c);
        }
    }
}
