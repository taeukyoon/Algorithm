import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 13019 a를 b로
 */
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String val1 = br.readLine();
        String val2 = br.readLine();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int size = val1.length();

        int cnt = 0;
        for (int i = 0; i < size; i++) {
            arr1[val1.charAt(i) - 'A']++;
            arr2[val2.charAt(i) - 'A']++;
        }

        for (int i = size - 1; i >= 0; i--) {
            if (val1.charAt(i) == val2.charAt(size - 1 - cnt)) {
                cnt++;
            }
        }
        boolean flag = false;
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                flag = true;
                break;
            }
        }
        System.out.println((flag) ? -1 : size - cnt);
    }
}
