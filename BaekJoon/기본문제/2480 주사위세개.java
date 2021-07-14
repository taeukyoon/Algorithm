import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[3];

        for(int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); //주사위값
        }
        if(arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[0]) {
            System.out.print(10000 +arr[0]*1000);
        }else if(arr[0] == arr[1]){
            System.out.print(1000 +arr[0] * 100);
        }else if(arr[1] == arr[2]) {
            System.out.print(1000 +arr[1] * 100);
        }else if(arr[2] == arr[0]) {
            System.out.print(1000 + arr[2] * 100);
        } else System.out.print(Math.max(Math.max(arr[0], arr[1]),arr[2])*100);
    }
}