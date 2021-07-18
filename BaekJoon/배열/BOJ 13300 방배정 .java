import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    /*
     BOJ 13300 방 배정
     */
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] room = new int[2][7];
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            room[s][b]++;
        }
        for(int i = 0; i < 2; i++){
            for(int j = 1; j < 7; j++) {
                cnt += room[i][j] / K;
                if(room[i][j] % K != 0) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

}