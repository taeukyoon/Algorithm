import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 BOJ 16987 계란으로 계란치기
 Date: 21-10-02

 solving
 1. 계란의 수가 주어지고, 그다음줄에는 계란의 내구도와 무게가 주어진다.
 2. 계란끼리 부딪치면 무게만큼 내구도가 깍이고 내구도가 0보다 작으면 계란이 파괴된다.
 3. 맞은 계란만 깨질 때, 둘다 깨질 때, 둘 다 안깨질 때, 든 계란이 깨질 때 고려한다.
 */
public class Main {
    static int N, max, cnt = 0;
    static Point[] egg; //좌표 0,0 지정
    static boolean flag = false;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        egg = new Point[N];


        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            egg[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        } //달걀에 정보까지 넣었음
        dfs(0);
        System.out.println(max);
    }
    public static void dfs(int idx) {
        if(idx == N) {  //idx랑 달걍의 갯수가 같아진다?
            max = Math.max(cnt, max);
            if(max == N) {
                flag = true;
            }
            return;
        }
        if(flag) {
            return;
        }
        if(egg[idx].x <= 0) {
            dfs(idx + 1);
            return;
        }
        int broken = 0;
        for(int i = 0; i < N; i++) {
            if(i == idx) {
                continue;
            }
            if(egg[i].x <= 0) {
                broken++;
                continue;
            }
            egg[idx].x -= egg[i].y; //내구도 깍이는 로직
            egg[i].x -= egg[idx].y;

            if(egg[i].x <= 0) {
                cnt++;
            }
            if(egg[idx].x <= 0) {
                cnt++;
            }
            dfs(idx + 1);

            if(egg[i].x <= 0) {
                cnt--;
            }
            if(egg[idx].x <= 0) {
                cnt--;
            }
            egg[idx].x += egg[i].y;
            egg[i].x += egg[idx].y;
        }
        if(broken == N-1) {
            dfs(idx + 1);
        }
    }
}