import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 BOJ 10804 카드 역배치
 */
class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[21];
        int temp;

        for(int i = 1; i < 21; i++){
            arr[i] = i;
        }
        for(int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());

            int mid = (a2 - a1) / 2; //중간위치

            for(int j = 0; j <= mid; j++) {
                temp = arr[a1 + j];
                arr[a1 + j] = arr[a2 - j];
                arr[a2 - j] = temp;
            }
        }
        for(int i = 1; i < 21; i++) {
            System.out.println(arr[i] + " ");
        }
    }
}