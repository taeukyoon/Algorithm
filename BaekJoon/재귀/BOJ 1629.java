import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 1629 곱셈
 Date: 2021-09-08
 */
public class Main{
    static long a, b, c;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(pow(a, b));
    }
    public static long pow(long a, long exponent) {
        if(exponent == 1) {
            return a % c;
        }

        long temp = pow(a, exponent / 2);

        //(temp * temp * a) % c;
        if(exponent % 2 == 1) {
            return (temp * temp %c) * a % c;
        }
        return temp * temp % c;
    }
}