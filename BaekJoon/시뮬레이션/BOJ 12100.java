import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N, res;
    static int[][] map;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0);
        System.out.println(res);
    }
    public static void solve(int cnt) {
        if(cnt == 5) { //최대 5번 이동시켜서 얻을 수 있는 큰 값
            findMax();
            return;
        }
        int[][] copy = new int[N][N];
        for(int i = 0; i < N; i++) { //백트래킹 위해서 카피 만들기
            copy[i] = map[i].clone();
        }

        for(int k = 0; k < 4; k++) {
            move(k);
            solve(cnt + 1);
            for(int i = 0; i < N; i++) { // 백트래킹
                map[i] = copy[i].clone();
            }
        }
    }
    public static void move(int dir) {
        switch (dir) {
            case 0: // 위
                for(int i = 0; i < N; i++) {
                    int block = 0;
                    int index = 0;
                    for(int j = 0; j < N; j++) {
                        if(map[j][i] != 0) { //끝에서 부터
                            if(block == map[j][i]) { // 같은 블럭이 있으면
                                map[index - 1][i] = block * 2; //블럭 더해준다
                                block = 0; //블럭 초기화
                                map[j][i] = 0; // 값 초기화
                            }
                            else { //블럭이 같은 경우가 아닐경우
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 1: // 아래
                for(int i = 0; i < N; i++) {
                    int block = 0;
                    int index = 0;
                    for(int j = 0; j < N; j++) {
                        if(map[i][j] != 0) { //끝에서 부터
                            if(block == map[i][j]) { // 같은 블럭이 있으면
                                map[i][index - 1] = block * 2; //블럭 더해준다
                                block = 0; //블럭 초기화
                                map[i][j] = 0; // 값 초기화
                            }
                            else { //블럭이 같은 경우가 아닐경우
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 2: // 왼
                for(int i = 0; i < N; i++) {
                    int block = 0;
                    int index = N - 1;
                    for(int j = N - 1; j >= 0; j--) {
                        if(map[j][i] != 0) { //끝에서 부터
                            if(block == map[j][i]) { // 같은 블럭이 있으면
                                map[index + 1][i] = block * 2; //블럭 더해준다
                                block = 0; //블럭 초기화
                                map[j][i] = 0; // 값 초기화
                            }
                            else { //블럭이 같은 경우가 아닐경우
                                block = map[j][i];
                                map[j][i] = 0;
                                map[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;

            case 3: // 오
                for(int i = 0; i < N; i++) {
                    int block = 0;
                    int index = N - 1;
                    for(int j = N - 1; j >= 0; j--) {
                        if(map[i][j] != 0) { //끝에서 부터
                            if(block == map[i][j]) { // 같은 블럭이 있으면
                                map[i][index + 1] = block * 2; //블럭 더해준다
                                block = 0; //블럭 초기화
                                map[i][j] = 0; // 값 초기화
                            }
                            else { //블럭이 같은 경우가 아닐경우
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }
    public static void findMax() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                res = Math.max(res, map[i][j]);
            }
        }
    }
}