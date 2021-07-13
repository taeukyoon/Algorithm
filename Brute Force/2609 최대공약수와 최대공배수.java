import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 백준 2069 최대공약수와 최소공배수
 재귀사용
 */
public class Main {

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int c = gcd(a,b); //최대공약수

        System.out.println(c);
        //두수를 곱한뒤 최대공약수로 나눠주면 최소공배수가 나온다.
        System.out.println(a * b / c);
    }

    public static int gcd(int a, int b) {
        if(a%b == 0) {
            return b;
        }else {
            return gcd(b, a % b);
        }
    }
}
