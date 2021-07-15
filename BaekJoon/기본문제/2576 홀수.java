import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 백준 2576 홀수
 */
class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE;
        int[] arr = new int[7];
        int sum = 0;

        for(int i = 0; i < 7; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] % 2 == 1) {
                sum += arr[i];
                min = Math.min(min, arr[i]);
            }
        }br.close();
        if(sum == 0) {
            System.out.println(-1);
        }else {
            System.out.println(sum);
            System.out.println(minval);
        }
    }
}