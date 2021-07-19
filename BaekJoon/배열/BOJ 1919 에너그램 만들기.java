import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 BOJ 1919 에너그램 만들기
 배열문제
 */

class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a1 = br.readLine();
        String a2 = br.readLine();
        int[] arr = new int[26];
        int[] arr2 = new int[26];
        int cnt = 0;

        for(int i = 0; i < a1.length(); i++) {
            arr[a1.charAt(i) - 'a'] ++;
        }
        for(int i = 0; i < a2.length(); i++) {
            arr2[a2.charAt(i) - 'a'] ++;
        }
        for(int i = 0; i < 26; i++) {
            if(arr[i] != arr2[i]) {
                cnt += Math.abs(arr[i] - arr2[i]);
            }
        }
        System.out.println(cnt);
    }
}