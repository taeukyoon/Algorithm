import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 백준 12813 이진수 연산
 BitMask
 */
class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[100001];
        int[] b = new int[100001];

        String s = br.readLine();
        String t = br.readLine();

        for(int i = 0; i <s.length(); i++) {
            a[i] = s.charAt(i) - '0';
            b[i] = t.charAt(i) - '0';
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            sb.append(a[i] & b[i]);
        }
        sb.append("\n");

        for(int i = 0; i < s.length(); i++) {
            sb.append(a[i] | b[i]);
        }
        sb.append("\n");

        for(int i = 0; i < s.length(); i++) {
            sb.append(a[i] ^ b[i]);
        }
        sb.append("\n");

        for(int i = 0; i < s.length(); i++) {
            sb.append(a[i] ^ 1);
        }
        sb.append("\n");

        for(int i = 0; i < s.length(); i++) {
            sb.append(b[i] ^ 1);
        }
        sb.append("\n");

        System.out.println(sb);
    }
}