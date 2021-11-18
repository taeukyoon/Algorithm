import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] arr;
    static int[][] players;
    static boolean[] visited;


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()); //2(승리), 1(비김), 0(짐)
            }
        }

        players = new int[3][20];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 20; i++) {
            players[1][i] = Integer.parseInt(st.nextToken()) - 1;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 20; i++) {
            players[2][i] = Integer.parseInt(st.nextToken()) - 1;
        }

        visited = new boolean[N];
        perm(0);
        System.out.println(0);
    }
    public static void perm(int s) {

        if(s == N) {
            int player1 = 0;
            int player2 = 1;
            int player3 = 2;
            int[] win = new int[3];
            int[] order = new int[3];
            boolean flag = false;

            while (true) {
                if(win[1] == K || win[2] == K) { //경희나 민우가 승수 다채우면 탈출
                    break;
                }
                else if(win[0] == K) {
                    flag = true;
                    break;
                }

                if(order[0] >= N) {
                    break;
                }

                if(arr[players[player1][order[player1]]][players[player2][order[player2]]] == 0) { //0은 앞사람이 진다
                    order[player1]++;
                    order[player2]++;

                    win[player2]++;
                    //3번쨰 주자랑 위치 바꾼다
                    int tmp = player1;
                    player1 = player3;
                    player3 = tmp;
                }

                else if(arr[players[player1][order[player1]]][players[player2][order[player2]]] == 2) {
                    order[player1]++;
                    order[player2]++;

                    win[player1]++;
                    int tmp = player2;
                    player2 = player3;
                    player3 = tmp;
                }

                else {
                    order[player1]++;
                    order[player2]++;

                    //비길시 뒤가 이김
                    if(player1 < player2) {
                        win[player2]++;
                        int tmp = player1;
                        player1 = player3;
                        player3 = tmp;
                    }
                    else {
                        win[player1]++;
                        int tmp = player2;
                        player2 = player3;
                        player3 = tmp;
                    }
                }
            }

            if(flag) {
                System.out.println(1);
                System.exit(0);
            }
            return;
        }
        //순열
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                players[0][s] = i;
                perm(s + 1);
                visited[i] = false;
            }
        }
    }
}
