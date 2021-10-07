import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 BOJ 15686
 Date: 21-10-07
 */
public class Main{
    static int N, M;
    static int res = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;
    static ArrayList<Node> house;
    static ArrayList<Node> chicken;
    static ArrayList<Node> selectChicken;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 1) {
                    house.add(new Node(i, j));
                }
                else if(arr[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }
        visited = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(res);
    }
    public static void dfs(int start, int cnt) {
        if(cnt == M) {
            int sum = 0;

            for(int i = 0; i < house.size(); i++) {
                int tmp = Integer.MAX_VALUE;
                for(int j = 0; j < chicken.size(); j++) {
                    if(visited[j]) {
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                        tmp = Math.min(tmp, distance);
                    }
                }
                sum += tmp;
            }
            res = Math.min(res, sum);
            return;
        }
        for(int i = start; i < chicken.size(); i++) {
            visited[i] = true;
            dfs(i + 1, cnt + 1);
            visited[i] = false;
        }
    }
    static class Node {
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x, y;
    }
}