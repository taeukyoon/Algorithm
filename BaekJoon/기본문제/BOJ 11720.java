import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 11720 숫자의 합
 */
public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        int sum = 0;
        String input = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[i] = input.charAt(i) - '0';
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
