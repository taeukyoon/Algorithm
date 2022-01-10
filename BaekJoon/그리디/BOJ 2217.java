import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 2217 로프
 */
public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int max = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = arr[i] * (n-i);
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
